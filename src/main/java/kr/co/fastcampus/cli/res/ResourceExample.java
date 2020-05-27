package kr.co.fastcampus.cli.res;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

//@Component
//public class ResourceExample implements ResourceLoaderAware {
//
//    private ResourceLoader resourceLoader;
//
//    @Override
//    public void setResourceLoader(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//
//    public void print(){
//        System.out.println(resourceLoader);
//    }
//}

@Component
public class ResourceExample{
    @Autowired
    private ResourceLoader resourceLoader;
    //여기 자체에서 autowired로 의존성을 넣어준거네!!!!
    //aware의 경우에는 주로 의존성과 관련된 것들임~..autowired로 사용 하면 된다

    public void print(){
        System.out.println(resourceLoader);
    }
}
