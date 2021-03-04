package org.whlf.myspringproj.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.whlf.myspringproj.entity.SysUser;
import org.whlf.myspringproj.mapper.SysUserMapper;
import org.whlf.myspringproj.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public int userLogin(SysUser user) {
        System.out.println(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        SysUser u = sysUserMapper.get(user);
        if (u == null) {
            return 0;
        } else {
            if (u.getPassword().equals(user.getPassword())) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int userRegiste(SysUser user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        int u = sysUserMapper.insertUser(user);
        if (u > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updatePassword(SysUser user) {
        return sysUserMapper.updatePassword(user);
    }

}
