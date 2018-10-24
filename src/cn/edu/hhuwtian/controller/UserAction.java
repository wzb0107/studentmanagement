package cn.edu.hhuwtian.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.hhuwtian.exception.AlterPasswordException;
import cn.edu.hhuwtian.exception.LoginException;
import cn.edu.hhuwtian.pojo.User;
import cn.edu.hhuwtian.service.UserService;

@Controller
public class UserAction {
	@Autowired
	private UserService userService;

	@RequestMapping("/userLogin.action")
	public String userLogin(User user, HttpSession session,
			String validateCode, HttpServletRequest request)
			throws LoginException {
		String validateCode_session = (String) session
				.getAttribute("validateCode_session");
		session.removeAttribute("validateCode_session");
		if (validateCode_session.equalsIgnoreCase(validateCode)) {
			User u = userService.userLogin(user);
			session.setAttribute("user", u);
			if ("1".equals(u.getPower())) {
				return "forward:admin/adminIndex.jsp";
			}
			if ("2".equals(u.getPower())) {
				return "forward:teacher/teacherIndex.jsp";
			}
			if ("3".equals(u.getPower())) {
				return "redirect:/findStudentScore.action";
			}
		}
		request.setAttribute("loginmessage", "验证码不正确");
		return "forward:login.jsp";
	}

	@RequestMapping("/alterPassword.action")
	public String alterPassword(String password, String rePassword,
			String newPassword, HttpSession session) throws AlterPasswordException {
		User user = (User) session.getAttribute("user");
		if(!password.equals(rePassword)){
			throw new AlterPasswordException("两次输入的密码不一致，请重新输入");
		}
		if(!password.equals(user.getPassword())) {
			throw new AlterPasswordException("输入的密码不正确，请重新输入");
		}
		User u = new User();
		u.setId(user.getId());
		u.setUsername(user.getUsername());
		u.setPower(user.getPower());
		u.setPassword(newPassword);
		userService.alterPassword(u);
		session.removeAttribute("user");
		return "redirect:login.jsp";
	}
	
	@RequestMapping("/userLogout.action")
	public String userLogout(HttpSession session) {
		session.invalidate();
		return "redirect:login.jsp";
	}
}
