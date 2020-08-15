package core;

import beans.SimpleBean;
import configuration.BeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainAppUsingJavaConfig {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        context.registerShutdownHook();
        SimpleBean simpleBean = (SimpleBean) context.getBean("bean1");
        System.out.println(simpleBean.getValue()+" "+simpleBean.getPropertyName());
    }
}
