package cn.edu.hhuwtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hhuwtian.dao.TStudentMapper;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TStudent;
import cn.edu.hhuwtian.service.StudentService;
import cn.edu.hhuwtian.util.Page;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private TStudentMapper studentMapper;
	
	@Override
	public Page<TStudent> findPageByQueryVo(QueryVo vo) {
		Page<TStudent> page = new Page<>();
		vo.setSize(5);
		page.setSize(5);
		if (vo != null) {
			if (vo.getPage() != null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			if (vo.getName() != null && !"".equals(vo.getName().trim())) {
				vo.setName(vo.getName().trim());
			}
			Integer total = studentMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TStudent> list = studentMapper
					.findStudentByQueryVo(vo);
			page.setRows(list);
		}
		return page;
	}

	@Override
	public void addStudent(TStudent student) {
		studentMapper.insert(student);
	}

	@Override
	public TStudent showStudent(Integer id) {
		TStudent student = studentMapper.selectByPrimaryKey(id);
		return student;
	}

	@Override
	public void updateStudent(TStudent student) {
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public Page<TStudent> findPageByQueryVo1(QueryVo vo) {
		Page<TStudent> page = new Page<>();
		vo.setSize(5);
		page.setSize(5);
		if (vo != null) {
			if (vo.getPage() != null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			if (vo.getName() != null && !"".equals(vo.getName().trim())) {
				vo.setName(vo.getName().trim());
			}
			Integer total = studentMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TStudent> list = studentMapper
					.findStudentByQueryVo1(vo);
			page.setRows(list);
		}
		return page;
	}
	
}
