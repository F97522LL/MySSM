package org.whlf.myspringproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.whlf.myspringproj.entity.Menus;

import java.util.List;

@Mapper
public interface MenusMapper {
    List<Menus> MenusList();
}
