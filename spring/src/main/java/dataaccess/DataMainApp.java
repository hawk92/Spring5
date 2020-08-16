package dataaccess;

import configuration.JDBCDataConfiguration;
import dataaccess.domains.Employee;
import dataaccess.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Collections;

public class DataMainApp {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "jdbc");
        AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(JDBCDataConfiguration.class);
        ConfigurableEnvironment env = appContext.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();
        propertySources.addFirst(new MapPropertySource("DUMMY", Collections.singletonMap("spring.profiles.active", "none")));

        System.out.println("Using JAVA_HOME " + env.getProperty("java.home"));
        System.out.println("Existing profile " + env.getProperty("spring.profiles.active"));
        System.out.println("New profile " + env.getProperty("spring.profiles.active"));

        appContext.registerShutdownHook();
        EmployeeService employeeService = (EmployeeService) appContext.getBean("employeeService");
        System.out.println("Employee with id is present " + employeeService.isEmployeePresent(1));
        System.out.println(employeeService.getEmployee(2));
        Employee e = new Employee(5, "Dummy");
        System.out.println("No of row inserted/updated " + employeeService.addEmployee(e));
        System.out.println(employeeService.getEmployeeByNameAlt("NICOle"));
        employeeService.printAllEmployees();
        System.out.println("Employee count " + employeeService.getNoOfEmployees());


    }
}
