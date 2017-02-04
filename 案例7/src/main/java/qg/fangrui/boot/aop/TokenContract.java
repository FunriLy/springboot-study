package qg.fangrui.boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import qg.fangrui.boot.exception.FormRepeatException;
import qg.fangrui.boot.exception.HttpServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 表单重复提交实现类 session-token
 * Created by zggdczfr on 2017/1/26.
 */
@Aspect
@Component
public class TokenContract {

    private static final Logger logger = LoggerFactory.getLogger(TokenContract.class);

    @Before("within(@org.springframework.stereotype.Controller *) && @annotation(token)")
    public void testToken(final JoinPoint joinPoint, Token token){
        try {
            if (token != null) {
                //获取 joinPoint 的全部参数
                Object[] args = joinPoint.getArgs();
                HttpServletRequest request = null;
                HttpServletResponse response = null;
                for (int i = 0; i < args.length; i++) {
                    //获得参数中的 request && response
                    if (args[i] instanceof HttpServletRequest) {
                        request = (HttpServletRequest) args[i];
                    }
                    if (args[i] instanceof HttpServletResponse) {
                        response = (HttpServletResponse) args[i];
                    }
                }

                if (request == null) {
                    logger.error("方法中缺失HttpServletRequest参数");
                    throw new HttpServletException("方法中缺失HttpServletRequest参数");
                }
                if (response == null){
                    logger.error("方法中缺失HttpServletResponse参数");
                    throw new HttpServletException("方法中缺失HttpServletResponse参数");
                }

                boolean needSaveSession = token.save();
                if (needSaveSession){
                    String uuid = UUID.randomUUID().toString();
                    request.getSession().setAttribute( "token" , uuid);
                    logger.debug("进入表单页面，Token值为："+uuid);
                }

                boolean needRemoveSession = token.remove();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                        logger.error("表单重复提交");
                        throw new FormRepeatException("表单重复提交");
                    }
                    request.getSession(false).removeAttribute( "token" );
                }
            }

        } catch (FormRepeatException e){
            throw e;
        } catch (HttpServletException e){
            throw e;
        } catch (Exception e){
            logger.error("token 发生异常 : "+e);
        }
    }

    private boolean isRepeatSubmit(HttpServletRequest request) throws FormRepeatException {
        String serverToken = (String) request.getSession( false ).getAttribute( "token" );
        if (serverToken == null ) {
            //throw new FormRepeatException("session 为空");
            return true;
        }
        String clinetToken = request.getParameter( "token" );
        if (clinetToken == null || clinetToken.equals("")) {
            //throw new FormRepeatException("请从正常页面进入！");
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            //throw new FormRepeatException("重复表单提交！");
            return true ;
        }
        logger.debug("校验是否重复提交：表单页面Token值为："+clinetToken + ",Session中的Token值为:"+serverToken);
        return false ;
    }
}
