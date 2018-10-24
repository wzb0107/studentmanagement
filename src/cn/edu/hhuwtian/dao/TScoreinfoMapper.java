package cn.edu.hhuwtian.dao;

import cn.edu.hhuwtian.pojo.TScoreinfo;
import cn.edu.hhuwtian.pojo.TScoreinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TScoreinfoMapper {
    int countByExample(TScoreinfoExample example);

    int deleteByExample(TScoreinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TScoreinfo record);

    int insertSelective(TScoreinfo record);

    List<TScoreinfo> selectByExample(TScoreinfoExample example);

    TScoreinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TScoreinfo record, @Param("example") TScoreinfoExample example);

    int updateByExample(@Param("record") TScoreinfo record, @Param("example") TScoreinfoExample example);

    int updateByPrimaryKeySelective(TScoreinfo record);

    int updateByPrimaryKey(TScoreinfo record);
}