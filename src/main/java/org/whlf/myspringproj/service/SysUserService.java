package org.whlf.myspringproj.service;

import org.whlf.myspringproj.entity.SysUser;

public interface SysUserService {
    int userLogin (SysUser user);
    int userRegiste (SysUser user);
    int updatePassword(SysUser user);
}
