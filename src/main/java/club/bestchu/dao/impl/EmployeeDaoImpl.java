package club.bestchu.dao.impl;

import club.bestchu.dao.EmployeeDao;
import club.bestchu.entity.Employee;
import club.bestchu.utils.JdbcUtil;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bestchu on 2017/7/17.
 */
public class EmployeeDaoImpl implements EmployeeDao{
    public List<Employee> getAll(){
        String sql = "select * from employee";
        try {
            return JdbcUtil.getQueryRunner().query(sql, new BeanListHandler<Employee>(Employee.class));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
