package Decorator;

import Builder.UserModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({LoginExtension.class, RandomUserResolver.class})
//наблюдатель декорадр
public class DecoratorTest {

    @Test
    public void coolLoogingTest(){
        System.out.println("Основная логіка порівняння значень");
        Assertions.assertTrue(2<5);
    }

    @Test
    public void deskTopTest(@RandomUser UserModel user){
        System.out.println(user);
        System.out.println("ok");
    }
}