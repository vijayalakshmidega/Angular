package com.empapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

	@GetMapping("helo")
	public ModelAndView hello() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("key", "This is Spring");
		return mv;
	}

}
