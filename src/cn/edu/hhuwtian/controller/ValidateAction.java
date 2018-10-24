package cn.edu.hhuwtian.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dsna.util.images.ValidateCode;

@Controller
public class ValidateAction {
	@RequestMapping("/showValidateCode.action")
	public void showValidateCode(HttpSession session,
			HttpServletResponse response) throws Exception {
		ValidateCode vc = new ValidateCode(100, 32, 4, 10);
		String validateCode = vc.getCode();
		session.setAttribute("validateCode_session", validateCode);
		vc.write(response.getOutputStream());
	}
}
