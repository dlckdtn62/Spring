package kr.co.fastcampus.cli.AOP;

import kr.co.fastcampus.cli.Dao;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

//public class Main {
//    public static void main(String[] args){
//        ProxyFactory factory = new ProxyFactory(new SimplePojo());
//        factory.addInterface(Pojo.class);
//        factory.addAdvice(new RetryAdvice());
//
//        Pojo pojo = (Pojo) factory.getProxy();
//        pojo.foo();
//    }
//}
//
//class RetryAdvice implements MethodInterceptor{
//
//
//    @Override
//    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//        //pojo.foo할 때 동작하는 코드로 보면 된다
//        return null;
//        //methodInvocation.proceed()로 하게 되면 foo가 실행되게 된다
//    }
//}
//
//interface Pojo{
//    void foo();
//}
//
//class SimplePojo implements Pojo{
//    @Override
//    public void foo() {
//        System.out.println("run foo");
//    }
//}
public class Main {
    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Connection connection = context.getBean(Connection.class);
        createTable(connection);
        Dao bean = context.getBean(Dao.class);
        bean.insert();
        bean.print();
        context.close();

    }

    public static void createTable(Connection connection) throws SQLException {
        connection.createStatement().execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
    }
}

//class not found는 spring에서 의존성 추가해 줘야 한다.