package kr.co.fastcampus.cli.res;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        ClassPathResource resource = new ClassPathResource("dao.xml");
//        byte[] bytes = resource.getInputStream().readAllBytes();
//        String daoStr = new String(bytes);
//        System.out.println(daoStr);

//        Resource resource = new UrlResource("file:C:\\Users\\dlckd\\fastcampus\\src\\main\\resources\\dao.xml");
//        //url은 절대 경로를 요구한다
//        byte[] bytes = resource.getInputStream().readAllBytes();
//        String daoStr = new String(bytes);
//        System.out.println(daoStr);

//        Resource resource = new FileSystemResource("C:\\Users\\dlckd\\fastcampus\\src\\main\\resources\\dao.xml");
//        //url과 달리 프로토콜을 명시하지는 않음
//        System.out.println(resource.exists());

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("dao.xml");
        context.close();
    }
}
