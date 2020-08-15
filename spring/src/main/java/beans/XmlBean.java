package beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;

public class XmlBean implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {

    private String beanName;
    private String name;
    private XmlDependencyBean dependencyBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public XmlDependencyBean getDependencyBean() {
        return dependencyBean;
    }

    public void setDependencyBean(XmlDependencyBean dependencyBean) {
        this.dependencyBean = dependencyBean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init1() " + this);
        this.name = "Value is set";
    }

    private void init() {
        System.out.println("init2() " + this);
        this.name = "Value is set again";
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("Set bean name");
        this.beanName = s;
    }

    @Override
    public String toString() {
        return "XmlBean{" +
                "beanName='" + beanName + '\'' +
                ", name='" + name + '\'' +
                ", dependencyBean=" + dependencyBean +
                '}';
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Set app context");
        AbstractApplicationContext abstractApplicationContext = (AbstractApplicationContext) applicationContext;
        abstractApplicationContext.registerShutdownHook();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy() " + this);
    }
}
