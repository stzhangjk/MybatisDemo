

import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by STZHANGJK on 2016/8/27.
 */
public class TestConfiguration006 {

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
            User user = session.selectOne("UserMapper.select",1);
            System.out.println(user.getUsername());
        }
    }
}
