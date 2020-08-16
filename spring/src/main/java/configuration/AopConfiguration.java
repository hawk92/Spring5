package configuration;

import beans.AopBean;
import beans.SimpleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"aop.aspects"})
@EnableAspectJAutoProxy
public class AopConfiguration {

    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBean();
    }

    @Bean(name = "aop")
    public AopBean aopBean() {
        return new AopBean(simpleBean());
    }
}
