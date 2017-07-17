package club.bestchu.service.impl;

import club.bestchu.dao.impl.AdminDaoImpl;
import club.bestchu.entity.Admin;
import club.bestchu.service.AdminService;

/**
 * Created by bestchu on 2017/7/17.
 */
public class AdminServiceImpl implements AdminService{
    private AdminDaoImpl adminDao = new AdminDaoImpl();

    public Admin findByNameAndPassword(Admin admin) {
        try{
            return adminDao.getByNameAndPassword(admin);
        }catch(Exception e){
            throw new RuntimeException();
        }
    }
}
