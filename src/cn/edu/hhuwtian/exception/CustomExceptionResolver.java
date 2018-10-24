package cn.edu.hhuwtian.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器的自定义实现类
 * 
 * @author 贾金磊
 *
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		ModelAndView mav = new ModelAndView();
		if(e instanceof LoginException){
			mav.addObject("error",((LoginException)e).getMsg());
			mav.setViewName("login.jsp");
			return mav;
		}
		if(e instanceof AlterPasswordException){
			mav.addObject("error",((AlterPasswordException)e).getMsg());
			mav.setViewName("other/alterpassword.jsp");
			return mav;
		}
		if(e instanceof CascadeDeleteException){
			mav.addObject("error",((CascadeDeleteException)e).getMsg());
			mav.setViewName("/collegeinfo.action");
			return mav;
		}
		mav.addObject("error", "未知异常");
		mav.setViewName("error.jsp");
		return mav;
	}

}
