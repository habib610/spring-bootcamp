package demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggersAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")

    public void beforeLoggers(){
        System.out.println("Before Loggers executed");
    }

    @After("execution(* * .*.checkout(..))")
    public void afterLoggers(){
        System.out.println("After Loggers executed");
    }
}
