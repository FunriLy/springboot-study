package qg.fangrui.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import qg.fangrui.boot.model.BlackList;

import java.util.List;

/**
 * Created by zggdczfr on 2017/2/6.
 */
@Mapper
public interface BlackListDao {
    // 根据IP来查找记录
    List<BlackList> findByIp(String ip);
    // 添加记录
    int addBlackList(@Param("blackList") BlackList blackList);
}
