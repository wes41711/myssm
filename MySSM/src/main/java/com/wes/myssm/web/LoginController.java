package com.wes.myssm.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wes.myssm.bean.User;
import com.wes.myssm.entity.Student;
import com.wes.myssm.entity.Teacher;
import com.wes.myssm.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/returnLogin")
	public String returnLogin() {
		System.out.println("進入Controller");
		return "login";
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		System.out.println("in login");

		ModelAndView mv = new ModelAndView("show");

		Object obj = userService.checkId(id, pwd);

		mv.addObject("obj", obj);
		return mv;
	}
}
