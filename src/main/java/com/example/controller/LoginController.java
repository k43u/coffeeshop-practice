package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.UserService;

/**
 * @author kashimamiyu
 * 
 * ログイン機能のコントローラー
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public LoginForm setUpLoginForm() {
		return new LoginForm();
	}
	
	@RequestMapping("")
	public String toLogin() {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null) {
			return "redirect:/shoppingList";
		}
		return "login";
	}
	
	@RequestMapping("/complete")
	public String login(LoginForm form, Model model) {
		User user = userService.login(form.getEmail(), form.getPassword());
		
		if(user == null) {
			model.addAttribute("errorMessage", "メールアドレス、またはパスワードが間違っています");
			return toLogin();
		}
		session.setAttribute("name", user.getName());
		return "redirect:/shoppingList";
	}
}
