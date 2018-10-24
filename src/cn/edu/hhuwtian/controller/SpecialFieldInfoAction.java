package cn.edu.hhuwtian.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.hhuwtian.exception.CascadeDeleteException;
import cn.edu.hhuwtian.pojo.QueryVo;
import cn.edu.hhuwtian.pojo.TCollegeinfo;
import cn.edu.hhuwtian.pojo.TSpecialfieldinfo;
import cn.edu.hhuwtian.service.CollegeInfoService;
import cn.edu.hhuwtian.service.SpecialFieldInfoService;
import cn.edu.hhuwtian.util.Page;

/**
 * 专业信息
 * @author 贾金磊
 *
 */
@Controller
public class SpecialFieldInfoAction {
	@Autowired
	private SpecialFieldInfoService specialFieldInfoService;
	@Autowired
	private CollegeInfoService collegeInfoService;
	
	@RequestMapping("/findSpecialFieldInfo.action")
	public String findSpecialFieldInfo(QueryVo vo,HttpServletRequest request) {
		List<TCollegeinfo> list = collegeInfoService.findAllCollege();
		Integer id = collegeInfoService.findCollegeId(vo);
		vo.setCollegeid(id);
		Page<TSpecialfieldinfo> page = specialFieldInfoService.findPageByQueryVo(vo);
		request.setAttribute("list",list);
		request.setAttribute("page",page);
		return "forward:other/specialfieldinfo.jsp";
	}
	
	@RequestMapping("/addSpecialFieldInfo.action")
	public String addSpecialFieldInfo(TSpecialfieldinfo specialfieldinfo) {
		specialFieldInfoService.addSpecialFieldInfo(specialfieldinfo);
		return "redirect:/findSpecialFieldInfo.action";
	}
	
	@RequestMapping("/showSpecialFieldInfo.action")
	public String showSpecialFieldInfo(Integer id,HttpServletRequest request) {
		TSpecialfieldinfo specialFieldInfo = specialFieldInfoService.showFieldInfo(id);
		request.setAttribute("specialFieldInfo", specialFieldInfo);
		return "forward:other/showspecialfieldinfo.jsp";
	}
	
	@RequestMapping("/updateSpecialInfo.action")
	public String updateSpecialFieldInfo(TSpecialfieldinfo specialfieldinfo) {
		specialFieldInfoService.updateSpecialFieldInfo(specialfieldinfo);
		return "redirect:/findSpecialFieldInfo.action";
	}

	@RequestMapping("/deleteSpecialFieldInfo.action")
	public String deleteSpecialFieldInfo(Integer id) throws CascadeDeleteException {
		System.out.println(id);
		specialFieldInfoService.deleteSpecialField(id);
		return "redirect:/findSpecialFieldInfo.action";
	}
}
