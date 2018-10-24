package cn.edu.hhuwtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.hhuwtian.dao.TCourseinfoMapper;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCourseinfo;
import cn.edu.hhuwtian.pojo.TCourseinfoExample;
import cn.edu.hhuwtian.pojo.TStudent;
import cn.edu.hhuwtian.service.CourseInfoService;
import cn.edu.hhuwtian.util.Page;
@Service
public class CourseInfoServiceImpl implements CourseInfoService {

	@Autowired
	private TCourseinfoMapper courseinfoMapper;
	@Override
	public Page<TCourseinfo> findPageByQueryVo(QueryVo vo) {
		Page<TCourseinfo> page = new Page<>();
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
			int total = courseinfoMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TCourseinfo> list = courseinfoMapper.findCourseInfoListByQueryVo(vo);
			page.setRows(list);
		}
		return page;
	}
	@Override
	public void deleteCourseInfo(Integer id) {
		courseinfoMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void addCourseInfo(TCourseinfo courseinfo) {
		courseinfoMapper.insert(courseinfo);
	}
	@Override
	public List<QueryVo> findAllCourse() {
		List<QueryVo> list = courseinfoMapper.findAllCourse();
		return list;
	}
	@Override
	public Integer findCourseId(QueryVo vo) {
		if (vo.getNumber() != null && !"".equals(vo.getNumber().trim())) {
			TCourseinfoExample example = new TCourseinfoExample();
			example.createCriteria().andNumberEqualTo(vo.getNumber());
			List<TCourseinfo> list = courseinfoMapper
					.selectByExample(example);
			return list.get(0).getId();
		}
		return null;
	}
	@Override
	public Page<TCourseinfo> findPageByQueryVo1(QueryVo vo) {
		Page<TCourseinfo> page = new Page<>();
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
			int total = courseinfoMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			List<TCourseinfo> list = courseinfoMapper.selectStudentById(vo);
			page.setRows(list);
		}
		return page;
	}
	@Override
	public Page<TCourseinfo> findStudentScore(TStudent student,QueryVo vo) {
		Page<TCourseinfo> page = new Page<>();
		vo.setSize(5);
		page.setSize(5);
		if(vo != null) {
			if(vo.getPage() != null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			int total = courseinfoMapper.findCountByQueryVo(vo);
			page.setTotal(total);
			vo.setNumber(student.getNumber());
			List<TCourseinfo> list = courseinfoMapper.selectCourse(vo);
			page.setRows(list);
		}
		return page;
	}
}
