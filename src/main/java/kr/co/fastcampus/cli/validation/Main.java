package kr.co.fastcampus.cli.validation;

import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.BindException;

@Slf4j
public class Main {
    public static void main(String[] args){
        Person person = new Person("", 200);
        PersonValidator personValidator = new PersonValidator();
        if(personValidator.supports(person.getClass())){
            BindException error = new BindException(person, "person");
            personValidator.validate(person, error);
            //단순히 Errors interface 사용하게 되면 제약 사항이 커지는
            //문제가 존재 So, 그 중에 하나 사용하는게 바람직하다
            log.error(">>"+error.hasErrors());
            log.error(""+error.getAllErrors());
        }else{
            log.error("invalid class");
        }

    }
}
