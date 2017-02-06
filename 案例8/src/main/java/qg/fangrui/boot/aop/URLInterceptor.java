package qg.fangrui.boot.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import qg.fangrui.boot.dao.BlackListDao;
import qg.fangrui.boot.exception.RequestLimitException;
import qg.fangrui.boot.model.BlackList;
import qg.fangrui.boot.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * URL 拦截器
 * Created by zggdczfr on 2017/2/6.
 */
public class URLInterceptor implements HandlerInterceptor {

    @Autowired
    BlackListDao blackListDao;

    private Map<String, Integer> redisTemplate = new HashMap<String, Integer>();
    private static final Logger logger = LoggerFactory.getLogger(URLInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String ip = IPAddressUtil.getClientIpAddress(httpServletRequest);
        List<BlackList> blackLists = blackListDao.findByIp(ip);
        if (blackLists == null || blackLists.size() == 0){
            urlHandle(httpServletRequest, 5000, 10);
        } else {
            modelAndView.setViewName("/errorpage/error.html");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void urlHandle(HttpServletRequest request, long limitTime,int limitCount) throws RequestLimitException {
        try {
            System.out.println("拦截器！！！");
            String ip = IPAddressUtil.getClientIpAddress(request);
            String url = request.getRequestURL().toString();
            final String key = "req_limit_".concat(url).concat(ip);

            if(redisTemplate.get(key)==null || redisTemplate.get(key)==0){
                redisTemplate.put(key,1);
            }else{
                redisTemplate.put(key,redisTemplate.get(key)+1);
            }
            int count = redisTemplate.get(key);
            if (count > 0) {
                Timer timer= new Timer();
                TimerTask task  = new TimerTask(){
                    @Override
                    public void run() {
                        redisTemplate.remove(key);
                    }
                };
                timer.schedule(task, limitTime);
            }
            if (count > limitCount){
                Calendar calendar = Calendar.getInstance();
                Date iptime=calendar.getTime();
                BlackList blackList = new BlackList(ip, iptime);
                blackListDao.addBlackList(blackList);
                throw new RequestLimitException();
            }
        } catch (RequestLimitException e) {
            throw e;
        } catch (Exception e) {
            logger.error("发生异常: ", e);
        }
    }
}
