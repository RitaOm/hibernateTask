package com.epam.testapp.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	private static final Logger LOG = Logger.getLogger(EmployeeController.class);
	
	
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET)
	public ModelAndView categories(ModelAndView model) {
		LOG.error("vsie chorosho!");
        model.setViewName("employeeList");
		return model;
	}
}


	