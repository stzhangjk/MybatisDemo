import entity.Blog;
import entity.Post;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by STZHANGJK on 2016/8/28.
 */
public class Test009 {

    private static SqlSessionFactory sf;

    @BeforeClass
    public static void config() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sf = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() {
        try(SqlSession session = sf.openSession()){
            HashMap params = new HashMap();
            params.put("id",1);
            params.put("title",null);
            Blog blog = session.selectOne("BlogMapper.selectOne",params);

            System.out.println(blog.getTitle());
            blog.setTitle("009test");
            params.put("title",blog.getTitle());
            session.update("BlogMapper.update",params);
            session.commit();
        }
    }
}
