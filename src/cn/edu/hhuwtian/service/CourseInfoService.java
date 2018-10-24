package cn.edu.hhuwtian.service;

import java.util.List;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCourseinfo;
import cn.edu.hhuwtian.pojo.TStudent;
import cn.edu.hhuwtian.util.Page;

public interface CourseInfoService {

	Page<TCourseinfo> findPageByQueryVo(QueryVo vo);

	void deleteCourseInfo(Integer id);

	void addCourseInfo(TCourseinfo courseinfo);

	List<QueryVo> findAllCourse();

	Integer findCourseId(QueryVo vo);

	Page<TCourseinfo> findPageByQueryVo1(QueryVo vo);

	Page<TCourseinfo> findStudentScore(TStudent student,QueryVo vo);
	
}
