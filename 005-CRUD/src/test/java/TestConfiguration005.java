
import entity.Gender;
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
public class TestConfiguration005 {

    private static SqlSessionFactory sf;

    @BeforeClass
    public static void config() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sf = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testInsert() {
        try(SqlSession session = sf.openSession()){
            User user = new User();
            user.setGender(Gender.WOMAN);
            user.setName("admin");
            int r = session.insert("UserMapper.insert",user);
            System.out.println("r=" + r);
        }
    }

    @Test
    public void testUpdate(){
        try(SqlSession session = sf.openSession()){
            User user = session.selectOne("UserMapper.select",1);
            System.out.println(user.getGender());
            user.setGender(Gender.WOMAN);
            System.out.println(session.update("UserMapper.update",user));
            session.commit();
        }
    }
}
