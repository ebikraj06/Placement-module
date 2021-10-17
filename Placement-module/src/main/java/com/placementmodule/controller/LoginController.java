package com.placementmodule.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.placementmodule.entities.Login;
import com.placementmodule.service.impl.LoginServiceImpl;

@Controller
public class LoginController {
	
	@Autowired
	private LoginServiceImpl loginService;
	 
	//login into Placement module
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new Login());
	    return mav;
	}
	 
	//Check the username and password for login
	@PostMapping("/login")
	public String login(@ModelAttribute("login") Login login ) {
		Login oauthUser = loginService.login(login.getUserName(), login.getPassword());
	    if(Objects.nonNull(oauthUser))
	    {
	    	return "redirect:/";
	    } else {
	    	return "redirect:/login";
	    }
	 }
	 
	//logout
	@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request,HttpServletResponse response){
		return "redirect:/login";
	}
}
