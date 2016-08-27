package plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * Created by STZHANGJK on 2016/8/27.
 */
@Intercepts({@Signature(
        type= Executor.class,
        method = "query",
        args = {
                MappedStatement.class,
                Object.class,
                RowBounds.class,
                ResultHandler.class
        })})
public class MyPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("before");
        Object obj = invocation.proceed();
        System.out.println("after");

        return obj;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

}
