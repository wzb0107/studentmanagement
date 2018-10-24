package cn.edu.hhuwtian.dao;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCollegeinfo;
import cn.edu.hhuwtian.pojo.TCollegeinfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TCollegeinfoMapper {
    int countByExample(TCollegeinfoExample example);

    int deleteByExample(TCollegeinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCollegeinfo record);

    int insertSelective(TCollegeinfo record);

    List<TCollegeinfo> selectByExample(TCollegeinfoExample example);

    TCollegeinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCollegeinfo record, @Param("example") TCollegeinfoExample example);

    int updateByExample(@Param("record") TCollegeinfo record, @Param("example") TCollegeinfoExample example);

    int updateByPrimaryKeySelective(TCollegeinfo record);

    int updateByPrimaryKey(TCollegeinfo record);

	Integer findCountByQueryVo(QueryVo vo);

	List<TCollegeinfo> findCollegeinfoListByQueryVo(QueryVo vo);

}