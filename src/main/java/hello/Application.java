package hello;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

/*
   @Bean
   ApplicationRunner runner(ApplicationContext ctx) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                String[] beans = ctx.getBeanDefinitionNames();
                Arrays.sort(beans);
                for (String s : beans) {
                    System.out.println(s);
                }
            }
        };
    }
*/
}
