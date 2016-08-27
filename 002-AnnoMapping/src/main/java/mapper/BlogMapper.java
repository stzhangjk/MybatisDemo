package mapper;

import entity.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * Created by STZHANGJK on 2016/8/27.
 */
public interface BlogMapper {
    @Select("select * from `_blog` where id = #{id}")
    Blog select(int id);
}
