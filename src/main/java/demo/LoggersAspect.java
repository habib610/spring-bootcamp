package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggersAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLoggers(JoinPoint jp){
        System.out.println(jp.getSignature());
        System.out.println(jp.getArgs()[0].toString());
        System.out.println("Before Loggers executed");
    }

    @After("execution(* * .*.checkout(..))")
    public void afterLoggers(){
        System.out.println("After Loggers executed");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturnPointcut(){}

    @AfterReturning(pointcut = "afterReturnPointcut()", returning = "retVal")
    public void afterReturning(String retVal){
        System.out.println("After Rutrn Value: " + retVal);
    }


}
