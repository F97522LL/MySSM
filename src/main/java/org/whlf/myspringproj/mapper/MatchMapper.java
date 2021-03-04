package org.whlf.myspringproj.mapper;

import org.whlf.myspringproj.entity.ImgList;
import org.whlf.myspringproj.entity.Match;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MatchMapper {
    List<Match> getMatchList();
    int addMatch(Match match);
    int addImg(ImgList imgList);
    int matchStart(Match match);
//    List<Match> getMatchDivision(Match match);
//    int matchEdit(Match match);
//    Match get(Match match);
//    Match getEdit(Match match);
//    int matchDel(Match match);
//    int matchStart(Match match);
//    int matchEnd(Match match);
//    int insertMatchImg(Match match);
}
