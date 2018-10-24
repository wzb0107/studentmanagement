package cn.edu.hhuwtian.dao;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TClassinfo;
import cn.edu.hhuwtian.pojo.TClassinfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TClassinfoMapper {
    int countByExample(TClassinfoExample example);

    int deleteByExample(TClassinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TClassinfo record);

    int insertSelective(TClassinfo record);

    List<TClassinfo> selectByExample(TClassinfoExample example);

    TClassinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TClassinfo record, @Param("example") TClassinfoExample example);

    int updateByExample(@Param("record") TClassinfo record, @Param("example") TClassinfoExample example);

    int updateByPrimaryKeySelective(TClassinfo record);

    int updateByPrimaryKey(TClassinfo record);

	int findCountByQueryVo(QueryVo vo);

	List<TClassinfo> findClassInfoListByQueryVo(QueryVo vo);

	List<QueryVo> findClassNumber();
}