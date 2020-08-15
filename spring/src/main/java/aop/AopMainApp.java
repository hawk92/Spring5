package aop;

import beans.AopBean;
import beans.SimpleBean;
import configuration.AopConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AopMainApp {

    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AopConfiguration.class);
        appContext.registerShutdownHook();
        SimpleBean simpleBean = (SimpleBean) appContext.getBean("simpleBean");
        System.out.println("Original message: " + simpleBean.getValue());
        AopBean aopBean = (AopBean) appContext.getBean("src/main/java/aop");
        aopBean.addValue("ABC", "Corp");
        System.out.println("Modified message: " + aopBean.getValue());
        aopBean.getValueWithException();
    }
}
