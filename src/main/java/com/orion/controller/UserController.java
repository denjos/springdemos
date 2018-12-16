package com.orion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orion.model.User;
import com.orion.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/",""},method=RequestMethod.GET)
	public ModelAndView getAllUsers()
	{
		ModelAndView model=new ModelAndView();
		List<User> userList=userService.getAllUser();
		model.addObject("userList",userList);
		model.setViewName("users_list");
		return model;
	}
	
	
}
