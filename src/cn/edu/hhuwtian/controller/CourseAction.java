package cn.edu.hhuwtian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCourseinfo;
import cn.edu.hhuwtian.pojo.TStudent;
import cn.edu.hhuwtian.pojo.User;
import cn.edu.hhuwtian.service.CourseInfoService;
import cn.edu.hhuwtian.service.TeacherService;
import cn.edu.hhuwtian.util.Page;

@Controller
public class CourseAction {
	@Autowired
	private CourseInfoService courseInfoService;
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/findcourseinfo.action")
	public String findCourseInfo(QueryVo vo, HttpServletRequest request) {
		String name = vo.getName();
		List<QueryVo> list = teacherService.findAllTeacher();
		vo.setName(name);
		Integer id = teacherService.findTeacherId(vo);
		vo.setTeacherid(id);
		Page<TCourseinfo> page = courseInfoService.findPageByQueryVo(vo);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		return "forward:other/courseinfo.jsp";
	}

	@RequestMapping("/deletecourseinfo.action")
	public String deleteCourseInfo(Integer id) {
		courseInfoService.deleteCourseInfo(id);
		return "redirect:/findcourseinfo.action";
	}

	@RequestMapping("/addcourseinfo.action")
	public String addCourseInfo(TCourseinfo courseinfo) {
		courseInfoService.addCourseInfo(courseinfo);
		return "redirect:/findcourseinfo.action";
	}

	@RequestMapping("/selectStudentById")
	public String selectStudentById(QueryVo vo, HttpServletRequest request) {
		String name = vo.getName();
		List<QueryVo> list = courseInfoService.findAllCourse();
		vo.setName(name);
		Integer id = courseInfoService.findCourseId(vo);
		vo.setCourseid(id);
		Page<TCourseinfo> page = courseInfoService.findPageByQueryVo1(vo);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		return "forward:other/studentselectcourseinfo.jsp";
	}

	@RequestMapping("/findStudentScore.action")
	public String findStudentScore(HttpServletRequest request,QueryVo vo) {
		User user = (User) request.getSession().getAttribute("user");
		TStudent student = new TStudent();
		student.setNumber(user.getUsername());
		Page<TCourseinfo> page = courseInfoService.findStudentScore(student,vo);
		request.setAttribute("page", page);
		return "forward:student/studentIndex.jsp";
	}
}
