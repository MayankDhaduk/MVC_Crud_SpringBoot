package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.model.student;
import com.servise.studentservice;

@Controller
public class studentcontroller {
	@Autowired
	studentservice studentservice;

	@RequestMapping("/")
	public ModelAndView index() {

		ModelAndView model = new ModelAndView();
		model.addObject("std", new student());
		model.addObject("data", studentservice.viewalldata());
		model.setViewName("registartion");

		return model;
	}

	@RequestMapping("/registartion")
	public ModelAndView index1() {
		ModelAndView model = new ModelAndView();
		model.addObject("std", new student());
		model.addObject("data", studentservice.viewalldata());
		model.setViewName("registartion");

		return model;
	}

	@RequestMapping("/reg")
	public ModelAndView registration(@ModelAttribute("std") student std) {
		studentservice.addorupdate(std);
		ModelAndView model = new ModelAndView();
		model.addObject("data", studentservice.viewalldata());
		model.addObject("std", new student());
		model.addObject("msg", "Registartion Successfully");
		model.setViewName("registartion");
		return model;
	}

	@RequestMapping("/delete")
	public RedirectView deleteuser(@RequestParam("did") int id) {

		studentservice.deletestd(id);
		return new RedirectView("registartion");
	}

	@RequestMapping("/edit")
	public ModelAndView getbyid(@RequestParam("eid") int id) {
		student s =  studentservice.getbyid(id);
		ModelAndView model = new ModelAndView();
		model.addObject("data", studentservice.viewalldata());
		model.addObject("std", s);
		model.setViewName("registartion");
		return model;
	}

}
