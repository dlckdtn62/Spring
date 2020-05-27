package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
@Slf4j
public class Dao {
    private Connection connection;
    //di를 사용해서 값을 받아주는 것

    public Dao(Connection connection){
        this.connection = connection;
    }
    //dao의 constructor field가 끝부분에 정의됨

    public void init(){
        log.info("init");
    }

    public void destroy(){
        log.info("destroy");
    }

    public void insert() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into member(username, password) values('Lee Chang Soo', 'abcd')");
    }


    public void print() throws SQLException {
            Statement statement = connection.createStatement();

            //autocommit dbms에서 자동 commit 하지 않게 하는 것
            //memory 모드는 table이 없어유
            //transaction으로 exception 발생시 roll back할 수 있게 하는 기능
            ResultSet resultSet = statement.executeQuery( "select id, username, password from member;");
            while(resultSet.next()){
                Member member = new Member("Lee Chang Soo", "1234");
                log.info(member.toString());
            }
//			if(true) throw new RuntimeException("sql error");
            //일부로 이처럼 error 발생시킬 수도 있다
    }
}
