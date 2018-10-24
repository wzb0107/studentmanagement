package cn.edu.hhuwtian.service;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TStudent;
import cn.edu.hhuwtian.util.Page;

public interface StudentService {

	Page<TStudent> findPageByQueryVo(QueryVo vo);

	void addStudent(TStudent student);

	TStudent showStudent(Integer id);

	void updateStudent(TStudent student);

	void deleteStudent(Integer id);

	Page<TStudent> findPageByQueryVo1(QueryVo vo);
	
}
