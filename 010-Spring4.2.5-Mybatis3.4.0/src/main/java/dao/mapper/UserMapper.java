package dao.mapper;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by STZHANGJK on 2016.9.9.
 */
public interface UserMapper {
    @Select("select * from _user where id=#{userId}")
    User selectOne(@Param("userId") int userId);
}
