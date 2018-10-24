package spring.boot.war;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:data-context.xml")
@PropertySource(value = "classpath:SpringBootToWar.properties")
@EnableEurekaClient
public class SpringBootWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWarApplication.class, args);
    }
}
