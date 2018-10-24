package cn.edu.hhuwtian.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TTeacher;
import cn.edu.hhuwtian.service.TeacherService;
import cn.edu.hhuwtian.service.UserService;
import cn.edu.hhuwtian.util.Page;

@Controller
public class TeacherAction {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private UserService userService;

	@RequestMapping("/findTeacher.action")
	public String findTeacher(QueryVo vo, HttpServletRequest request) {
		Page<TTeacher> page = teacherService.findPageByQueryVo(vo);
		request.setAttribute("page", page);
		return "forward:teacher/teacherinfo.jsp";
	}

	@RequestMapping("/addTeacher.action")
	public String addTeacher(TTeacher teacher,MultipartFile pictureFile) throws Exception {
		String name = UUID.randomUUID().toString().replaceAll("-", "0");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		System.out.println(ext);
		File file = new File("F:\\upload\\" + name+ "." + ext);
		pictureFile.transferTo(file);
		teacher.setPhoto(name+ "." + ext);
		teacherService.addTeacher(teacher);
		userService.addUser(teacher.getNumber(),teacher.getPassword(),"2");
		return "redirect:/findTeacher.action";
	}
	
	@RequestMapping("/showTeacher.action")
	public String showTeacher(Integer id,HttpServletRequest request) {
		TTeacher teacher = teacherService.showTeacher(id);
		request.setAttribute("teacher", teacher);
		return "forward:teacher/showTeacher.jsp";
	}
	
	@RequestMapping("/updateTeacher.action")
	public String updateTeacher(TTeacher teacher) {
		teacherService.updateTeacher(teacher);
		return "redirect:/findTeacher.action";
	}
	
	@RequestMapping("/deleteTeacher.action")
	public String deleteTeacher(Integer id) {
		teacherService.deleteTeacher(id);
		return "redirect:/findTeacher.action";
	}
}
