package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dataModels.UserModel;
import com.springmvc.services.UserAuth;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.html",method=RequestMethod.GET)
	public ModelAndView getLoginPage() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping(value="/submitLogin.html",method=RequestMethod.POST)
	public ModelAndView auth(@ModelAttribute("userModel1") UserModel userModel1) {
		ModelAndView mv;
		UserAuth auth = new UserAuth();
		boolean isValid = auth.isValid(userModel1.getUsername(), userModel1.getPassword());
		if(isValid) {
			mv = new ModelAndView("loginsuccess");
		}else {
			mv = new ModelAndView("loginerror");
		}
		return mv;
	}
}
