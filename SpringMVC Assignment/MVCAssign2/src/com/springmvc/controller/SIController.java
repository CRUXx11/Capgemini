package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.classes.SimpleInterest;


@Controller
public class SIController {
	
	@RequestMapping("/simpleInterest.html")
	public ModelAndView interestController(@ModelAttribute("simpleInterest1") SimpleInterest simpleInterest1) {
		ModelAndView mv = new ModelAndView("calculateSI");
		mv.addObject("ans", simpleInterest1.getInterest());
		return mv;
	}

}