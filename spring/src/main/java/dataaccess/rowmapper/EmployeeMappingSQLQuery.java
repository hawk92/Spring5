package dataaccess.rowmapper;

import dataaccess.domains.Employee;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class EmployeeMappingSQLQuery extends MappingSqlQuery<Employee> {

    private static String sql = "select * from employee where lower(name) = :ename";

    public EmployeeMappingSQLQuery(DataSource dataSource) {
        super(dataSource, sql);
        super.setParameters(new SqlParameter("ename", Types.VARCHAR));
    }

    @Override
    protected Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("ID"));
        employee.setName(resultSet.getString("NAME"));
        return employee;
    }
}
