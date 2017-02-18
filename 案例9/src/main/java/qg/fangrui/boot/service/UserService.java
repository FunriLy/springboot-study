package qg.fangrui.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import qg.fangrui.boot.dao.UserDao;
import qg.fangrui.boot.exception.CacheException;
import qg.fangrui.boot.model.User;

/**
 * User Service 层
 * 主要是对缓存的操作
 * Created by zggdczfr on 2017/1/23.
 */
@Service
public class UserService {

    /**
     * 在支持Spring Cache的环境下
     * //@Cacheable Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。
     * //@CacheEvict 清除缓存
     * //@CachePut @CachePut也可以声明一个方法支持缓存功能。使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
     *
     * 注解中的 value 指的是 ehcache.xml 中的缓存策略
     */


    //这里的单引号不能少，否则会报错，被识别是一个对象
    private static final String CACHE_KEY = "'user'";
    private static final String DEMO_CACHE_NAME = "users";

    @Autowired
    private UserDao userDao;

    //删除用户数据
    @CacheEvict(value = DEMO_CACHE_NAME,key = "'user_'+#uuid")//这是清除缓存
    public void delete(String uuid){
        userDao.delete(uuid);
    }

    //更新用户数据
    @CachePut(value = DEMO_CACHE_NAME,key = "'user_'+#user.getUuid()")
    public User update(User user) throws CacheException{
        User user1 = userDao.findByUuid(user.getUuid());
        if (null == user1){
            throw new  CacheException("Not Find");
        }
        user1.setAge(user.getAge());
        user1.setName(user.getName());
        return user1;
    }

    //查找用户数据
    @Cacheable(value=DEMO_CACHE_NAME,key="'user_'+#uuid")
    public User findByUuid(String uuid){
        System.err.println("没有走缓存！"+uuid);
        return userDao.findByUuid(uuid);
    }

    //保存用户数据
    @CacheEvict(value=DEMO_CACHE_NAME,key=CACHE_KEY)
    public int save(User user){
        return userDao.save(user);
    }
}
