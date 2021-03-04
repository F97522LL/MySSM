package org.whlf.myspringproj.service;

import org.whlf.myspringproj.entity.ImgList;
import org.whlf.myspringproj.entity.Match;

import java.util.List;

public interface MatchService {
    List<Match> getMatchList();
    int addMatch(Match match);
    int addImg(ImgList imgList);
    int matchStart(Match match);
//    List<Match> getMatchDivision(Match match);
//    int matchEdit(Match match);
//    Match getEdit(Match match);
//    int matchDel(Match match);

//    int matchEnd(Match match);
//    int insertMatchImg(Match match);
}
