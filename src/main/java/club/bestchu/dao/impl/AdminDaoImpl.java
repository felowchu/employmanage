package club.bestchu.dao.impl;

import club.bestchu.dao.AdminDao;
import club.bestchu.entity.Admin;
import club.bestchu.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by bestchu on 2017/7/17.
 */
public class AdminDaoImpl implements AdminDao{
    public Admin getByNameAndPassword(Admin admin) {
        QueryRunner qr = JdbcUtil.getQueryRunner();
        String sql = "select * from admin where name = ? and password = ?";
        try {
            Admin result = qr.query(sql, new BeanHandler<Admin>(Admin.class), admin.getName(), admin.getPassword());
            return result;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
