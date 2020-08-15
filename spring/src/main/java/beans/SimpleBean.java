package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

public class SimpleBean {

    private String value;
    private String propertyName;

    public SimpleBean() {
    }

    public SimpleBean(@Value("Make in India") String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Autowired
    @Value("Happy Java config")
    public void setValue(String value) {
        this.value = value;
    }

    private void init() {
        System.out.println("Init called");
    }

    private void destroy() {
        System.out.println("Destroy called");
    }
}
