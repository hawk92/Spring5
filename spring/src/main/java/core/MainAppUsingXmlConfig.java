package core;

import beans.AnnotationBean;
import beans.XmlBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppUsingXmlConfig {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        XmlBean xmlBean = (XmlBean) context.getBean("xb");
        AnnotationBean annotationBean = (AnnotationBean) context.getBean("ab");
        System.out.println(xmlBean);
        System.out.println(annotationBean);
    }
}
