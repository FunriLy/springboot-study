package qg.fangrui.boot.dao;

import org.apache.ibatis.annotations.Param;
import qg.fangrui.boot.model.User;
import org.apache.ibatis.annotations.Mapper;
/**
 * Created by zggdczfr on 2017/1/22.
 */
@Mapper
public interface UserDao{

    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);

    /**
     * 查询某个用户
     * @param name
     * @return
     */
    User findByName(String name);
}
