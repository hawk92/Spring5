package configuration;

import beans.SimpleBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@PropertySource("classpath:properties.txt")
public class BeanConfiguration {

    @Value("${propertyName}")
    private String propertyName;

    @Bean(initMethod = "init", destroyMethod = "destroy", name = {"bean1", "bean2"})
    public SimpleBean simpleBean() {
        SimpleBean simpleBean = new SimpleBean();
        simpleBean.setPropertyName(propertyName);
        return simpleBean;
    }

    @PostConstruct
    private void init() {
        System.out.println("Config init");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Config destroy");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer pspConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
