package org.whlf.myspringproj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whlf.myspringproj.entity.Menus;
import org.whlf.myspringproj.mapper.MenusMapper;
import org.whlf.myspringproj.service.MenusService;

import java.util.List;

@Service
public class MenusServiceImpl implements MenusService {
    @Autowired
    MenusMapper menusMapper;
    @Override
    public List<Menus> MenusList() {
        return menusMapper.MenusList();
    }
}
