package mapper;

import entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by STZHANGJK on 2016/8/27.
 */
public interface UserMapper {
    @Select("select * from `_user` where id = #{id}")
    User select(int id);
}
