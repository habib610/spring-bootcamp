package demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
//    The different aspects
//    Logging
//    Authentication and Authorization
//    Sanitization

    public void checkout(String status){
        System.out.println("Shopping cart method is called");
    }

    public int quantity(){
        return 2;
    }
}
