package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class A {
    private B b;

    public A(B b){
        this.b = b;
    }

    @PostConstruct
    void init(){
        log.error("A Post Construct");
    }

    @PreDestroy
    void destroy(){
        log.error("A pre Destroy");
    }

//    만약 bean태그 설정을 xml에서 하지 않으면 (required=false...naming조건 처럼 )로서 할 수도 있기는 해

//    @Autowired
//    public A(B b){
//        this.b = b;
//        //원래는 autowired 안하면 null으로 생성자 넣어지지만, 업그레이드 되어 자동 할당됨
//    }
//    @Autowired
//    private ApplicationContext context;
    //굳이 aware 안쓰고도 이렇게 넘겨줄 수도 있어
    
}

//@confiuration
//class
//@bean
//public B b2{
//    return new B();
//        }
//처럼 bean을 개별 등록 하지 않고도 사용 가능
//만약 동일 내용이 있다면 두개의 bean을 만드는 과정에서 ... @primary 설정해서 우선 순위 줄 수 있음
//단 여기서는 appconfig라는 파일 하에 작성시 bean class = appconfig는 해 줘야 한다.
//qualifier에서 사용하고자 하는 bean id를 찾아서 넣을 수 있음.. 즉 여기서는 a에서 사용하고자 하는 bean을 설정하는 것
//@propertySource()