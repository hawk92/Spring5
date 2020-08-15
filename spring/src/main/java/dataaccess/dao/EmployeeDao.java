package dataaccess.dao;

import dataaccess.domains.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private RowMapper<Employee> rowMapper;

    private final static String EMPLOYEE_NAME_PARAMETER = "ename";

    public long getRowCountForId(long id) {
        String sql = "select count(*) from employee where id=?";
        return jdbcTemplate.queryForObject(sql, Long.class, id);
    }

    public long getEmployeeCount() {
        String sql = "select * from employee_cnt";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }

    public List<Map<String, Object>> getAllRowsAsMap() {
        String sql = "select * from employee";
        return jdbcTemplate.queryForList(sql);
    }

    public Employee getEmployee(long id) {
        String sql = "select * from employee where id = ?";
        return (Employee) jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public Employee getEmployeeByName(String name) {
        String sql = "select * from employee where lower(name) = :" + EMPLOYEE_NAME_PARAMETER;
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put(EMPLOYEE_NAME_PARAMETER, name.trim().toLowerCase());
        return (Employee) namedParameterJdbcTemplate.queryForObject(sql, paramMap, rowMapper);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insertEmployee(Employee e) {
        String sql = "insert into employee values (?,?)";
        if (jdbcTemplate.update(sql, e.getId(), e.getName()) > 0) {
            return updateEmployeeCount();
        } else {
            return 0;
        }
    }

    private int updateEmployeeCount() {
        String sql = "update employee_cnt set emp_cnt=emp_cnt+1";
        return jdbcTemplate.update(sql);
    }
}
