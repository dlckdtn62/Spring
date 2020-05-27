package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.service.MyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.sql.Connection;

@Configuration
@Profile("default || dev")
@PropertySource("classpath:application-${spring.profiles.active}.properties")
//{"default", "dev"}
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public B b() {return new B();}

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public A a (B b){
        return new A(b);
    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory){
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection){
        return new Dao(connection);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ConnectionFactory connectionFactory(
            @Value("${jdbc.driver-name}") String driverClass,
            @Value("${jdbc.url}") String url, @Value("${jdbc.username}") String username, @Value("${jdbc.password}") String password

    ){
        return new ConnectionFactory(driverClass, url, username, password);
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
        //공식 문서에서 추가해야 한다고 지정 된 것
    }

    @Bean
    public MyService myService(){
        return new MyService();
    }
}
