package club.bestchu.service;

import club.bestchu.entity.Admin;

/**
 * Created by bestchu on 2017/7/17.
 */
public interface AdminService {
    Admin findByNameAndPassword(Admin admin);
}
