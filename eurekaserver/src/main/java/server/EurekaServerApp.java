package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
@RefreshScope
public class EurekaServerApp {

    public static void main(String[] args) {
        //System.setProperty("spring.config.name","server");
        SpringApplication.run(EurekaServerApp.class);
    }

}
