package EQUAL_IDENTITY_TEST;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class BeanScopeTest {

//    @Test
//    public void testIdentity(){
//        //identity : obj1, obj2, obj3 ...obj==obj
//        //equal : ogj1.equals(obj2) == true...값이 같다
//
//        A a1 = new A();
//        A a2 = new A();
//        Assert.assertTrue(a1==a2);
//    }

    @Test
    public void testEquals(){
        A a1 = new A(10, "Hello World");
        A a2 = new A(10, "Hello World");

        A a3 = new A(5, "Hello");

        Assert.assertEquals(a1, a2);
        Assert.assertFalse(a1.equals(a3));

    }
}

class A{
    private int a1;
    private String a2;

    public A(int a1, String a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof A)) return false;
        A a = (A)obj;
        return this.a1 == a.a1 && Objects.equals(this.a2, a2);
    }
    //lombok으로 equalshashcode로 할 수 있다!!!
}
