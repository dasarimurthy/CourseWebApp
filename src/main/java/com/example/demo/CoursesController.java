package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoursesController {
	
	
	@RequestMapping("coursesr")
	//@ResponseBody
	public String coursesr(HttpServletRequest req) {
		System.out.println("Welcome to course:"+ req.getAttribute("cname"));
		//session.setAttribute("cname", courseName);
		return "course";
	}
	
	@RequestMapping("courseso")
	//@ResponseBody
	public String courseso(@RequestParam("cname") String courseName, HttpSession session) {
		//System.out.println("Welcome to course:"+ req.getAttribute("cname"));
		session.setAttribute("cname", courseName);
		return "course";
	}
	
	@RequestMapping("courses")
	public ModelAndView courses(@RequestParam("cname") String courseName ) {
		System.out.println("Welcome to ModelAndView:"+ courseName);
		ModelAndView mv= new ModelAndView();
		mv.addObject("cname",courseName);
		mv.setViewName("course");
		return mv;
	}
	
	
	@RequestMapping("coursesres")
	@ResponseBody
	public String coursesres(@RequestParam("cname") String courseName ) {
		return "Learn Course Name :" + courseName;
	}

}
