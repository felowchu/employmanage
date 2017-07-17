package club.bestchu.dao;

import club.bestchu.entity.Employee;

import java.util.List;

/**
 * Created by bestchu on 2017/7/17.
 */
public interface EmployeeDao {
    List<Employee> getAll();
}
