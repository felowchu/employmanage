package club.bestchu.service.impl;

import club.bestchu.dao.EmployeeDao;
import club.bestchu.dao.impl.EmployeeDaoImpl;
import club.bestchu.entity.Employee;
import club.bestchu.service.EmployeeService;

import java.util.List;

/**
 * Created by bestchu on 2017/7/17.
 */
public class EmployeeServiceImpl implements EmployeeService{
    private  EmployeeDao employeeDao = new EmployeeDaoImpl();

    public List<Employee> getAll() {
        try{
            return employeeDao.getAll();
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}
