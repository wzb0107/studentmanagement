package cn.edu.hhuwtian.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCourseinfo;
import cn.edu.hhuwtian.pojo.TCourseinfoExample;
import cn.edu.hhuwtian.pojo.TStudent;

public interface TCourseinfoMapper {
    int countByExample(TCourseinfoExample example);

    int deleteByExample(TCourseinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCourseinfo record);

    int insertSelective(TCourseinfo record);

    List<TCourseinfo> selectByExample(TCourseinfoExample example);

    TCourseinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCourseinfo record, @Param("example") TCourseinfoExample example);

    int updateByExample(@Param("record") TCourseinfo record, @Param("example") TCourseinfoExample example);

    int updateByPrimaryKeySelective(TCourseinfo record);

    int updateByPrimaryKey(TCourseinfo record);

	int findCountByQueryVo(QueryVo vo);

	List<TCourseinfo> findCourseInfoListByQueryVo(QueryVo vo);

	List<QueryVo> findAllCourse();

	Integer findCourseId(QueryVo vo);
	
	List<TCourseinfo> selectStudentById(QueryVo vo);

	List<TCourseinfo> selectCourse(QueryVo vo);

}