package cn.edu.hhuwtian.service;

import java.util.List;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TTeacher;
import cn.edu.hhuwtian.util.Page;

public interface TeacherService {

	Page<TTeacher> findPageByQueryVo(QueryVo vo);

	void addTeacher(TTeacher teacher);

	TTeacher showTeacher(Integer id);

	void updateTeacher(TTeacher teacher);

	void deleteTeacher(Integer id);

	List<QueryVo> findAllTeacher();

	Integer findTeacherId(QueryVo vo);

}
