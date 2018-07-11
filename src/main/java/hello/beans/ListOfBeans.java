package hello.beans;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ListOfBeans {
   @Bean
   ApplicationRunner runner(ApplicationContext ctx) {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                Arrays.stream(ctx.getBeanDefinitionNames())
                        //.sorted()
                        .forEach(System.out::println);
            }
        };
    }
}
