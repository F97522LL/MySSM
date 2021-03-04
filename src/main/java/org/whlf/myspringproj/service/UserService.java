package org.whlf.myspringproj.service;

import org.whlf.myspringproj.entity.Admin;

import java.util.List;

public interface UserService {
    List<Admin> getAdminList(Admin admin);
    List<Admin> getAdminList1();
    int  deleteAdmin(String id);
    Admin getAdmin(Admin admin);
    int updateAdmin (Admin admin);
    int adminInsert(Admin admin);
}
