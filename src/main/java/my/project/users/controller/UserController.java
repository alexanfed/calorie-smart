package my.project.users.controller;

import java.util.List;

import my.project.users.service.RoleService;
import my.project.users.util.Util;
import my.project.users.bean.RoleBean;
import my.project.users.bean.UserBean;
import my.project.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RoleService roleService;

	@Autowired
	UserService userService;
	
	@ModelAttribute("roles")
	public List<RoleBean> listRoles(){
		return this.roleService.list();
	}
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/user/list")
	public ModelAndView list() {
		
		logger.debug("Listing Users");
		
		List<UserBean> users = this.userService.list();
		
		return new ModelAndView("user-list","users",users);
	}
	
	@GetMapping("/user/create")
	public String showCreate() {
		
		logger.debug("Show User Create");
		
		return "user-create";
	}

	@PostMapping("/user/create")
	public String createUser(HttpServletRequest req) {
		
		logger.debug("Create User");
		
		String first = req.getParameter("first");
		String last = req.getParameter("last");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String registered = req.getParameter("registered");
		String calPerDay = req.getParameter("calPerDay");
		
		String idRole = req.getParameter("role");
		
		UserBean user = this.createUserBean(null,first, last, username, password, registered, calPerDay);
		
		this.userService.createUser(user, Util.parseId(idRole));
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/user/update/{id}")
	public ModelAndView showUpdate(@PathVariable Long id) {
		
		logger.debug("Show User Update");
		
		UserBean user = this.userService.findUser(id);
		
		return new ModelAndView("user-update","user",user);
	}
	
	@PostMapping("/user/update")
	public String updateUser(HttpServletRequest req) {
		
		logger.debug("Update User");

		String id = req.getParameter("id");
		String first = req.getParameter("first");
		String last = req.getParameter("last");
		String username = req.getParameter("username");
		String registered = req.getParameter("registered");
		String calPerDay = req.getParameter("calPerDay");
		String idRole = req.getParameter("role");
		
		UserBean user = this.createUserBean(id, first, last, username, null, registered, calPerDay);
		
		this.userService.updateUser(user,Util.parseId(idRole));
		
		return "redirect:/user/list";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		
		logger.debug("Delete User");

		this.userService.deleteUser(id);
		
		return "redirect:/user/list";
	}

	public Logger getLogger() {
		return logger;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private UserBean createUserBean(String id, String first, String last, String username, String password, String registered, String calPerDay) {
		
		UserBean user = new UserBean(Util.parseId(id),first,last,username,password,Util.parseDate(registered),"A",Util.parseCalPerDay(calPerDay));
		
		return user;
	}
	
}
