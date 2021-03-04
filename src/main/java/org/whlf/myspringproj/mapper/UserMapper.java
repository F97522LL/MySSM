package org.whlf.myspringproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.whlf.myspringproj.entity.Admin;

import java.util.List;
@Mapper
public interface UserMapper {
    List<Admin> getAdminList(Admin admin);
    List<Admin> getAdminList1();
    Admin deleteAdmin(String adminid);
    Admin getAdmin(Admin admin);
    int updateAdmin(Admin admin);
    int adminInsert(Admin admin);
}
