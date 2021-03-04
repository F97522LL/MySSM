package org.whlf.myspringproj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.whlf.myspringproj.entity.Admin;

import org.whlf.myspringproj.mapper.UserMapper;
import org.whlf.myspringproj.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Admin> getAdminList(Admin admin) {
        return userMapper.getAdminList(admin);
    }

    @Override
    public List<Admin> getAdminList1() {
        return userMapper.getAdminList1();
    }

    @Override
    public int deleteAdmin(String adminid) {
        Admin a = userMapper.deleteAdmin(adminid);
        if (a != null) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return userMapper.getAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        admin.setAdminPwd(DigestUtils.md5DigestAsHex(admin.getAdminPwd().getBytes()));
        int a = userMapper.updateAdmin(admin);
        if (a > 0) {
            return 1;
        } else {
            return 0;
        }
    }
    @Override
    public int adminInsert(Admin admin){
        admin.setAdminPwd(DigestUtils.md5DigestAsHex(admin.getAdminPwd().getBytes()));
        int a= userMapper.adminInsert(admin);
        if(a>0){
            return 1;
        }else{
            return 0;
        }
    }
}
