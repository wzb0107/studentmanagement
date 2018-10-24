package cn.edu.hhuwtian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TClassinfo;
import cn.edu.hhuwtian.service.ClassInfoService;
import cn.edu.hhuwtian.service.SpecialFieldInfoService;
import cn.edu.hhuwtian.util.Page;
@Controller
public class ClassInfoAction {
	@Autowired
	private ClassInfoService classInfoService;
	@Autowired
	private SpecialFieldInfoService specialFieldInfoService;
	
	@RequestMapping("/findClassInfo.action")
	public String findClassInfo(QueryVo vo,HttpServletRequest request) {
		String name = vo.getName();
		List<QueryVo> list = specialFieldInfoService.findAllSpecialField();
		vo.setName(name);
		Integer id = specialFieldInfoService.findSpecialFieldId(vo);
		vo.setSpacialfieldid(id);
		Page<TClassinfo> page = classInfoService.findPageByQueryVo(vo);
		request.setAttribute("list",list);
		request.setAttribute("page",page);
		return "forward:other/classinfo.jsp";
	}
	
	@RequestMapping("/showClassInfo.action")
	public String showClassInfo(Integer id,HttpServletRequest request) {
		TClassinfo classinfo = classInfoService.showClassInfo(id);
		request.setAttribute("classinfo", classinfo);
		return "forward:other/showclassinfo.jsp";
	}
	
	@RequestMapping("/updateClassinfo.action")
	public String updateClassinfo(TClassinfo classinfo) {
		classInfoService.updateClassInfo(classinfo);
		return "redirect:/findClassInfo.action";
	}
	
	@RequestMapping("/deleteClassInfo.action")
	public String deleteClassinfo(Integer id) {
		classInfoService.deleteClassInfo(id);
		return "redirect:/findClassInfo.action";
	}
}
