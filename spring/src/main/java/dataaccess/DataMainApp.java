package dataaccess;

import configuration.DataConfiguration;
import dataaccess.domains.Employee;
import dataaccess.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class DataMainApp {

    public static void main(String[] args) {
        AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(DataConfiguration.class);
        appContext.registerShutdownHook();
        EmployeeService employeeService = (EmployeeService) appContext.getBean("employeeService");
        System.out.println("Employee with id is present " + employeeService.isEmployeePresent(1));
        System.out.println(employeeService.getEmployee(2));
        Employee e = new Employee(5, "Dummy");
        System.out.println("No of row inserted/updated " + employeeService.addEmployee(e));
        System.out.println(employeeService.getEmployeeByName("NICOle"));
        employeeService.printAllEmployees();
        System.out.println("Employee count " + employeeService.getNoOfEmployees());
    }
}
