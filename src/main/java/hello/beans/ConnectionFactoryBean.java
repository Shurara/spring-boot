package hello.beans;

import hello.entities.User;
import org.hibernate.cfg.Environment;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class ConnectionFactoryBean {
    private static SessionFactory sessionFactory;

    @Bean
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Properties prop = new Properties() {{
                put(Environment.DRIVER, "org.postgresql.Driver");
                put(Environment.URL, "jdbc:postgresql://localhost:5432/danit");
                put(Environment.USER, "postgres");
                put(Environment.PASS, "pg123457");
                put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
                put(Environment.NON_CONTEXTUAL_LOB_CREATION, "true");
            }};
            sessionFactory = new org.hibernate.cfg.Configuration()
                    .addProperties(prop)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        }
        return sessionFactory;
    }
}
