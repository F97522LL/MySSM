package org.whlf.myspringproj.mapper;

import org.whlf.myspringproj.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface SysUserMapper {
    SysUser get(SysUser user);
    int updatePassword(SysUser user);
    int insertUser(SysUser user);
}
