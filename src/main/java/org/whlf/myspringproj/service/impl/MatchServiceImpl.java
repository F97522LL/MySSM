package org.whlf.myspringproj.service.impl;

import org.whlf.myspringproj.entity.ImgList;
import org.whlf.myspringproj.mapper.MatchMapper;
import org.whlf.myspringproj.entity.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.whlf.myspringproj.service.MatchService;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    MatchMapper matchMapper;

    @Override
    public List<Match> getMatchList() {
        return matchMapper.getMatchList();
    }
    @Override
    public int addMatch(Match match) {
        return matchMapper.addMatch(match);
    }
    @Override
    public  int addImg(ImgList imgList){
        return  matchMapper.addImg(imgList);
    }
    @Override
    public int matchStart(Match match){
        return matchMapper.matchStart(match);
    }
//    @Override
//    public List<Match> getMatchDivision(Match match) {
//        return matchMapper.getMatchDivision(match);
//    }
//
//
//    @Override
//    public int matchEdit(Match match) {
//        return matchMapper.matchEdit(match);
//    }
//
//
//
//    @Override
//    public Match getEdit(Match match) {
//        return matchMapper.getEdit(match);
//    }
//
//    @Override
//    public int matchDel(Match match) {
//        return matchMapper.matchDel(match);
//    }
//
//
//    @Override
//    public int matchEnd(Match match) {
//        return matchMapper.matchEnd(match);
//    }
//
//    @Override
//    public int insertMatchImg(Match match) {
//        return matchMapper.insertMatchImg(match);
//    }

}
