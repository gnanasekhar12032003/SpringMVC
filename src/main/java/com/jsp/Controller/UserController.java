package com.jsp.Controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dao.UserDao;

@Controller
public class UserController {
	
	@Autowired
	UserDao dao;
	
	@RequestMapping("/loginvalidation")
	public ModelAndView loginValidation(ServletRequest request,HttpSession session) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User u=dao.login(email, password);
		ModelAndView mav=new ModelAndView();
		if(u!=null) {
			mav.setViewName("useroptions");
			session.setAttribute("userobj", u);
			return mav;
		}
		else {
			mav.addObject("message","invalid credentials");
			mav.setViewName("login");
			return mav;
		}
	}
	
	@RequestMapping("/adduser")
	public ModelAndView addUser() {
		User u=new User();
		ModelAndView mav=new ModelAndView();
		mav.addObject("userobj",u);
		mav.setViewName("User");
		return mav;
	}
	
	@RequestMapping("/saveUserInfo")
	public ModelAndView saveuserinformation(@ModelAttribute("userobj") User u) {
		dao.saveUser(u);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","data saved successfully");
		mav.setViewName("addUser");
		return mav;
	}
	
	
	@RequestMapping("/saveUser")
    public String saveUserInfo(ServletRequest request) {
   	 
     String name=request.getParameter("name");
   	 String email=request.getParameter("email");
   	 String password=request.getParameter("password");
   	 String mobilenumber=request.getParameter("mobilenumber");
   	 				
   	 User user =new User();
   	 user.setName(name);
   	 user.setEmail(email);
   	 user.setPassword(password);
   	 user.setMobilenumber(mobilenumber);
   	
   	 dao.saveUser(user);
   	 
   	 return "UserOutput";
    }
	
	
	
	@RequestMapping("/fetchalldata")
	public ModelAndView  fetchAllUsers() {
		List<User> users=dao.findAllUser();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("allusersinfo",users);
		mav.setViewName("viewallusers");
		return mav;
	}
	
	@RequestMapping("/deleteuser")
	public ModelAndView deleteUser(@RequestParam("id") int id) {
		dao.deleteUserById(id);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect://fetchalldata");
		return mav;
	}
	
    }
