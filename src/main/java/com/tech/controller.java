package com.tech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.LoginService;

@Controller
public class controller {
	@Autowired
	LoginService Logindao;
	public controller() {
		System.out.println("inside controller constructor");
	}
	@RequestMapping("/login")
	public ModelAndView validateUser(@RequestParam("uname")String uname,@RequestParam("password")String password) {
	System.out.println("inside login validateUser");
	System.out.println(uname);
	System.out.println(password);
	//if user is present in db then success else error
	boolean userPresent=loginService.validateUser(uname,password);
	if(userPresent) {
		System.out.println("---success case----");
		ModelAndView mav=new ModelAndView("lgin-success");
		return mav;
	}else {
		System.out.println("---error case---");
		ModelAndView mav=new ModelAndView("login-error");
		return mav;
	}
	}
}
