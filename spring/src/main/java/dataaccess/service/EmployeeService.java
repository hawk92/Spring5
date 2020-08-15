package dataaccess.service;

import dataaccess.dao.EmployeeDao;
import dataaccess.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional(propagation = Propagation.MANDATORY)
    public int addEmployee(Employee e) {
        return employeeDao.insertEmployee(e);
    }

    public boolean isEmployeePresent(long id) {
        return (employeeDao.getRowCountForId(id) > 0 ? true : false);
    }

    public long getNoOfEmployees() {
        return employeeDao.getEmployeeCount();
    }

    public void printAllEmployees() {
        System.out.println("Column name : Column value");
        employeeDao.getAllRowsAsMap().
                forEach(row -> {
                    row.forEach((key, value) -> {
                        System.out.println(key + " : " + value);
                    });
                });
    }

    public Employee getEmployee(long id) {
        return employeeDao.getEmployee(id);
    }

    public Employee getEmployeeByName(String name) {
        return employeeDao.getEmployeeByName(name);
    }
}
