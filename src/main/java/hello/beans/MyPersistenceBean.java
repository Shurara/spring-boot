package hello.beans;

import hello.controller.MyPersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyPersistenceBean {
    @Bean
    public MyPersistence build1() {
        return new MyPersistence();
    }
}
