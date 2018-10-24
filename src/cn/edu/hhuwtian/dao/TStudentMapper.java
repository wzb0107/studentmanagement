package cn.edu.hhuwtian.dao;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TStudent;
import cn.edu.hhuwtian.pojo.TStudentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TStudentMapper {
    int countByExample(TStudentExample example);

    int deleteByExample(TStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    List<TStudent> selectByExample(TStudentExample example);

    TStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByExample(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);

	Integer findCountByQueryVo(QueryVo vo);

	List<TStudent> findStudentByQueryVo(QueryVo vo);

	List<TStudent> findStudentByQueryVo1(QueryVo vo);
}