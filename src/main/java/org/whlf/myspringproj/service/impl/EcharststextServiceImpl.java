package org.whlf.myspringproj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whlf.myspringproj.entity.Echarststext;
import org.whlf.myspringproj.mapper.EcharststextMapper;
import org.whlf.myspringproj.service.EcharststextService;

import java.util.List;

@Service
public class EcharststextServiceImpl implements EcharststextService {
    @Autowired
    EcharststextMapper echarststextMapper;
    @Override
    public List<Echarststext> getEa(Echarststext echarststext) {
        return echarststextMapper.getEa(echarststext);
    }

}
