import entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * Created by STZHANGJK on 2016.9.9.
 */
public class Test010 {
    @Test
    public void testConn(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserService service = (UserService)context.getBean("userService");
        User u = service.getUser(1);
        System.out.println(u.getUsername());
    }
}
