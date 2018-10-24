package cn.edu.hhuwtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hhuwtian.dao.TTeacherMapper;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TTeacher;
import cn.edu.hhuwtian.pojo.TTeacherExample;
import cn.edu.hhuwtian.service.TeacherService;
import cn.edu.hhuwtian.util.Page;
@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TTeacherMapper teacherMapper;
	@Override
	public Page<TTeacher> findPageByQueryVo(QueryVo vo) {
		Page<TTeacher> page = new Page<>();
		vo.setSize(5);
		page.setSize(5);
		if(vo != null) {
			if(vo.getPage() != null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			if(vo.getName() != null && !"".equals(vo.getName().trim())){
				vo.setName(vo.getName().trim());
			}
			int total = teacherMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TTeacher> list = teacherMapper.findTeacherListByQueryVo(vo);
			page.setRows(list);
		}
		return page;
	}
	@Override
	public void addTeacher(TTeacher teacher) {
		teacherMapper.insert(teacher);
	}
	@Override
	public TTeacher showTeacher(Integer id) {
		TTeacher teacher = teacherMapper.selectByPrimaryKey(id);
		return teacher;
	}
	@Override
	public void updateTeacher(TTeacher teacher) {
		teacherMapper.updateByPrimaryKeySelective(teacher);
	}
	@Override
	public void deleteTeacher(Integer id) {
		teacherMapper.deleteByPrimaryKey(id);
	}
	@Override
	public List<QueryVo> findAllTeacher() {
		List<QueryVo> list = teacherMapper.findAllTeacher();
		return list;
	}
	@Override
	public Integer findTeacherId(QueryVo vo) {
		if (vo.getNumber() != null && !"".equals(vo.getNumber().trim())) {
			TTeacherExample example = new TTeacherExample();
			example.createCriteria().andNumberEqualTo(vo.getNumber());
			List<TTeacher> list = teacherMapper
					.selectByExample(example);
			return list.get(0).getId();
		}
		return null;
	}
	
}
