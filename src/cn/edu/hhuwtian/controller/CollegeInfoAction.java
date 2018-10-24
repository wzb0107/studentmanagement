package cn.edu.hhuwtian.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.hhuwtian.exception.CascadeDeleteException;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCollegeinfo;
import cn.edu.hhuwtian.service.CollegeInfoService;
import cn.edu.hhuwtian.util.Page;

/**
 * 院系信息
 * 
 * @author 贾金磊
 * 
 */
@Controller
public class CollegeInfoAction {
	@Autowired 
	private CollegeInfoService collegeInfoService;

	@RequestMapping("/collegeinfo.action")
	public String findCollegeInfo(QueryVo vo,HttpServletRequest request) {
		Page<TCollegeinfo> page = collegeInfoService.findPageByQueryVo(vo);
		request.setAttribute("page",page);
		return "forward:other/collegeinfo.jsp";
	}
	
	@RequestMapping("/addCollegeinfo.action")
	public String addCollegeInfo(TCollegeinfo collegeinfo){
		collegeInfoService.addCollegeInfo(collegeinfo);
		return "forward:/collegeinfo.action";
	}
	
	@RequestMapping("/showCollegeinfo.action")
	public String showCollegeinfo(Integer id,HttpServletRequest request) {
		TCollegeinfo collegeinfo = collegeInfoService.showCollegeInfo(id);
		request.setAttribute("collegeinfo", collegeinfo);
		return "forward:other/showcollegeinfo.jsp";
	}
	
	@RequestMapping("/deleteCollegeinfo.action")
	public String deleteCollegeInfo(Integer id) throws CascadeDeleteException {
		collegeInfoService.deleteCollegeInfo(id);
		return "forward:/collegeinfo.action";
	}
	
	@RequestMapping("/updateCollegeinfo.action")
	public String updateCollegeInfo(TCollegeinfo collegeinfo) {
		collegeInfoService.updateCollegeInfo(collegeinfo);
		return "forward:/collegeinfo.action";
	}
}
