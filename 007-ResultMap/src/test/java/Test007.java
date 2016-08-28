import entity.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by STZHANGJK on 2016/8/28.
 */
public class Test007 {

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
            Blog blog =  session.selectOne("BlogMapper.selectOne",1);
            System.out.println(blog.getAuthor().getName());
        }
    }
}
