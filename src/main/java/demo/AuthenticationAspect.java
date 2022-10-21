package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component()
public class AuthenticationAspect {

    @Pointcut("within(demo..*)")
    public void authenticationPointCut(){

    }
    @Pointcut("within(demo..*)")
    public void autherizationPointCuts(){

    }
    @Before("authenticationPointCut() && autherizationPointCuts()")
    public void authenticateRequest(){
        System.out.println("Authenticating the request ");
    }
}
