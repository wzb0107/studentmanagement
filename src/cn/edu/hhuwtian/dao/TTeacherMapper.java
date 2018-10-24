package cn.edu.hhuwtian.dao;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TTeacher;
import cn.edu.hhuwtian.pojo.TTeacherExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TTeacherMapper {
    int countByExample(TTeacherExample example);

    int deleteByExample(TTeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTeacher record);

    int insertSelective(TTeacher record);

    List<TTeacher> selectByExample(TTeacherExample example);

    TTeacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTeacher record, @Param("example") TTeacherExample example);

    int updateByExample(@Param("record") TTeacher record, @Param("example") TTeacherExample example);

    int updateByPrimaryKeySelective(TTeacher record);

    int updateByPrimaryKey(TTeacher record);

	int findCountByQueryVo(QueryVo vo);

	List<TTeacher> findTeacherListByQueryVo(QueryVo vo);

	List<QueryVo> findAllTeacher();
}