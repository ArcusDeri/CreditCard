package pl.marcinm.pp5.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main (String[] args){
        System.out.println("Hello intellij");
        SpringApplication.run(Application.class, args);
    }
}
