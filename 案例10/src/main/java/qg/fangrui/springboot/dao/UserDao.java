package qg.fangrui.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import qg.fangrui.springboot.model.User;

/**
 * User Dao 接口
 * Created by zggdczfr on 2017/2/28.
 */
@Mapper
public interface UserDao {

    void delete(String uuid);

    int update(@Param("ruser") User user);

    User findByUuid(String uuid);

    int save(@Param("ruser") User user) throws Exception;
}
