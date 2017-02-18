package qg.fangrui.boot.dao;

import org.apache.ibatis.annotations.Param;
import qg.fangrui.boot.model.User;
import org.apache.ibatis.annotations.Mapper;
/**
 * Created by zggdczfr on 2017/1/22.
 */
@Mapper
public interface UserDao{

    void delete(String uuid);

    User update(User user);

    User findByUuid(String uuid);

    int save(@Param("user") User user);
}
