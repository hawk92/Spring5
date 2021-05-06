package beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("ab")
public class AnnotationBean implements InitializingBean, BeanNameAware, ApplicationContextAware {

    private String beanName;
    private String name;
    private XmlDependencyBean dependencyBean;

    public String getName() {
        return name;
    }

    public AnnotationBean(){
        System.out.println("Annotation");
    }

    @Autowired
    public void setName(@Value("Stunner") String name) {
        this.name = name;
    }

    public XmlDependencyBean getDependencyBean() {
        return dependencyBean;
    }

    @Autowired
    public void setDependencyBean(XmlDependencyBean dependencyBean) {
        this.dependencyBean = dependencyBean;
    }

    @PostConstruct
    private void init() {
        System.out.println("init1() " + this);
        this.name = "Value is set";
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Set bean name");
        this.beanName = s;
    }

    @Override
    public String toString() {
        return "AnnotationBean{" +
                "beanName='" + beanName + '\'' +
                ", name='" + name + '\'' +
                ", dependencyBean=" + dependencyBean +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Set app context");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("destroy() " + this);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init2() " + this);
        this.name = "Value is set again";
    }
}
