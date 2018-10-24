package cn.edu.hhuwtian.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TStudent;
import cn.edu.hhuwtian.service.ClassInfoService;
import cn.edu.hhuwtian.service.CourseInfoService;
import cn.edu.hhuwtian.service.StudentService;
import cn.edu.hhuwtian.service.UserService;
import cn.edu.hhuwtian.util.Page;

@Controller
public class StudentAction {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ClassInfoService classInfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private CourseInfoService courseInfoService;

	@RequestMapping("/findStudent.action")
	public String findStudent(QueryVo vo, HttpServletRequest request) {
		String name = vo.getName();
		List<QueryVo> list = classInfoService.findAllClass();//查询所有班级的number和name
		vo.setName(name);
		Integer id = classInfoService.findClassId(vo);//根据QueryVo里的number查询班级ID
		vo.setClassid(id);
		Page<TStudent> page = studentService.findPageByQueryVo(vo);
		request.setAttribute("list",list);
		request.setAttribute("page",page);
		return "forward:student/studentinfo.jsp";
	}
	
	@RequestMapping("/addStudent.action")
	public String addStudent(TStudent student,MultipartFile pictureFile) throws Exception {
		String name = UUID.randomUUID().toString().replaceAll("-", "0");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		System.out.println(ext);
		File file = new File("F:\\upload\\" + name+ "." + ext);
		pictureFile.transferTo(file);
		student.setPhoto(name+ "." + ext);
		studentService.addStudent(student);
		userService.addUser(student.getNumber(),student.getPassword(),"3");
		return "redirect:/findStudent.action";
	}
	
	@RequestMapping("/showStudent.action")
	public String showStudent(Integer id,HttpServletRequest request) {
		TStudent student = studentService.showStudent(id);
		request.setAttribute("student", student);
		return "forward:student/showStudent.jsp";
	}
	
	@RequestMapping("/updateStudent.action")
	public String updateStudent(TStudent student,MultipartFile pictureFile) throws Exception {
		String name = UUID.randomUUID().toString().replaceAll("-", "0");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		System.out.println(ext);
		File file = new File("F:\\upload\\" + name+ "." + ext);
		pictureFile.transferTo(file);
		student.setPhoto(name+ "." + ext);
		studentService.updateStudent(student);
		return "redirect:/findStudent.action";
	}
	
	@RequestMapping("/deleteStudent.action")
	public String deleteStudent(Integer id) {
		studentService.deleteStudent(id);
		return "redirect:/findStudent.action";
	}
	
	@RequestMapping("/findstudentselectcourseinfo.action")
	public String findStudentSelectCourseInfo(QueryVo vo,HttpServletRequest request) {
		String name = vo.getName();
		List<QueryVo> list = courseInfoService.findAllCourse();
		vo.setName(name);
		Integer id = courseInfoService.findCourseId(vo);//根据QueryVo里的number查询班级ID
		vo.setCourseid(id);
		Page<TStudent> page = studentService.findPageByQueryVo1(vo);
		request.setAttribute("list",list);
		request.setAttribute("page",page);
		return "forward:other/studentselectcourseinfo.jsp";
	}
}
