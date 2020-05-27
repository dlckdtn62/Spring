package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.AOP.TransactionBean;
import kr.co.fastcampus.cli.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class)
//거르는 방법...filter
class Main{
	private static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		log.info("Hello World!!");
		//auto는 자동 close 라서 finally 안써도 된다.(try with resource)

//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
//		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		//annotation만으로도 spring 작동하는 AnnoationConfigure

//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.register(TransactionBean.class);
		//annotation화 된 것 두개 등록 해준 것
		context.refresh();
//		MyService myService = context.getBean(MyService.class);
//		myService.check();
		createTable(context.getBean(Connection.class));
		//get bean으로 말 그대로 찾는 거임
		Dao dao = context.getBean(Dao.class);
		dao.insert();
		dao.print();
		context.close();
//		B b = context.getBean(B.class);
//		log.info(""+b);
//		System.out.println(context);
		//객체의 HASHVALUE가 나온다
//		Dao dao = context.getBean("dao", Dao.class);
//		//위의 dao.class는 기본 생성자에 해당되므로
//		//만약 constructor에서 매개변수 받으면 오류가 무조건 나와
//		//springframe work의 bean에서 객체 생성
//		dao.run();
		//lazy-init을 설정해 주게 되면 실제 method 구동 시에 생성자가 호출이 되어짐
//		A a1 = context.getBean("A", A.class);
//		A a2 = context.getBean("A", A.class);
//
//		log.info("result "+(a1==a2));
		//spring은 default가 singleton이다

//		ConnectionFactory factory = context.getBean(ConnectionFactory.class);
		//destroy 있는 경우 종료 가능

//		Dao dao = context.getBean("dao", Dao.class);
//		dao.run();
//		applicationcontextaware는 다른 class에서도 사용하고 싶을 때 사용하고 싶은 class에서 사용

	}
	public static void createTable(Connection connection) throws SQLException {
		connection.createStatement().execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
	}
}