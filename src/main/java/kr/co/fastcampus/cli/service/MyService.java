package kr.co.fastcampus.cli.service;

import kr.co.fastcampus.cli.validation.PersonForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
@Slf4j
public class MyService {
    @Autowired
    private Validator validator;

    public void check(){
        PersonForm personform = new PersonForm(null, 200);
        Set<ConstraintViolation<PersonForm>> results = validator.validate(personform);
        if(results.isEmpty()){
            log.info("validate 성공");
        }
        else{
            log.info("validate 실패");
        }
    }
}
