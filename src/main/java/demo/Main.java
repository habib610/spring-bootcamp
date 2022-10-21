package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext  applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
    ShoppingCart cart = applicationContext.getBean(ShoppingCart.class);
    cart.checkout("Cancelled");
    }
}
