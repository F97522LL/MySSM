package org.whlf.myspringproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.whlf.myspringproj.entity.Echarststext;

import java.util.List;

@Mapper
public interface EcharststextMapper {
    List<Echarststext> getEa(Echarststext echarststext);
}
