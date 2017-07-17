package club.bestchu.dao;

import club.bestchu.entity.Admin;

/**
 * Created by bestchu on 2017/7/17.
 */
public interface AdminDao {
    Admin getByNameAndPassword(Admin admin);
}
