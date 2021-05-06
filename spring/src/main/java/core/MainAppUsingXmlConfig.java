package core;

import beans.XmlBean;
import beans.XmlDependencyBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAppUsingXmlConfig {


    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        XmlBean xmlBean1 = (XmlBean) context.getBean("xb");
        XmlBean xmlBean2 = (XmlBean) context.getBean("xb");

        System.out.println(xmlBean1 == xmlBean2);
        //AnnotationBean annotationBean = (AnnotationBean) context.getBean("ab");
        System.out.println(xmlBean1);
        //System.out.println(annotationBean);
        System.out.println("Creating manually");
        XmlDependencyBean dependencyBean = (XmlDependencyBean) context.getBean("dependency");

    }
}
