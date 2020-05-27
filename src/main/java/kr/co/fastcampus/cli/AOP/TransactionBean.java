package kr.co.fastcampus.cli.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Aspect
public class TransactionBean {
//    public void log(){
//        log.error(">>> aop log");
//    }
//
//    public void beforelog(){
//        log.error(">>>>>before aop log");
//    }
//
//    public void afterlog(){
//        log.error(">>> after aop log");
//    }
//
//    public void afterReturnlog(){
//        log.error(">>> afterReturning aop log");
//    }
//    public void afterThrowinglog(){
//        log.error(">>>> afterThrowing aop log");
//    }
    private Connection connection;
    //xml도 pointcut 이 aspect 안에 존재한다


    public TransactionBean(Connection connection){
        this.connection = connection;
    }

    @Pointcut("execution(* kr.co.fastcampus.cli.Dao.insert(..))")
    public void transactionPointcut(){}
    
    @Around("transactionPointcut()")
    //pointcut의 method만 호출해서 지정 시킨다
    public Object aroundLog(ProceedingJoinPoint pjp) throws SQLException {
        log.error(">>>> before log");
        connection.setAutoCommit(false);
        try{
            Object proceed = pjp.proceed();
            log.error(">>> after returning log");
            connection.commit();
            return proceed;
        }catch(Throwable thorowable){
            log.error(">> throwing log");
            connection.rollback();
        }
        log.error(">>>> after log");
        return null;
    }
}
