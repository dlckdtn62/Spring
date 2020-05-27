package kr.co.fastcampus.cli;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Slf4j
public class ConnectionFactory{
    private String driverClass;
    private String url;
    private String user;
    private String password;
    @Getter private Connection connection = null;

    public ConnectionFactory(String driverClass, String url, String user, String password){
        this.driverClass = driverClass;
        this.url = url;
        this.user =user;
        this.password = password;
    }
    public Connection createConnection() throws SQLException {
        try {
            Class.forName(this.driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(this.url, this.user, this.password);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        this.connection = createConnection();
//    }

    public void destroy() throws Exception {
        if(this.connection != null) this.connection.close();
        log.info("destroy");
        //단순히 applicationcntext로 변수 선언되면 close method를 포함하지 않아
    }

    public void init() throws Exception {
        log.info("init");
        this.connection = createConnection();
    }
}
