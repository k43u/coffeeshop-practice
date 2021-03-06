package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.domain.model.GroupOrder;
import com.example.form.UserRegisterForm;
import com.example.service.UserService;

/**
 * @author kashimamiyu
 *
 * ユーザー登録のコントローラー
 */
@Controller
@RequestMapping("/register")
public class UserRegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@ModelAttribute
	public UserRegisterForm setUpUserRegisterForm() {
		return new UserRegisterForm();
	}
	
	/**
	 * ユーザー登録画面を表示
	 * @return ユーザー登録画面
	 */
	@RequestMapping("")
	public String toRegister() {
		Integer userId = (Integer) session.getAttribute("userId");
		if(userId != null) {
			return "redirect:/shoppingList";
		}
		return "register_user";
	}
	
	/**
	 * ログイン画面を表示
	 * @param form
	 * @return ログイン画面
	 */
	@RequestMapping("/insert")
	public String insert (@Validated(GroupOrder.class)UserRegisterForm form
			              ,BindingResult result) {
User duplicateUser = userService.findByEmail(form.getEmail());
		
		if (duplicateUser != null) {
			result.rejectValue("email", null, "このメールアドレスは既に登録されています");
		}
		
		if(!form.getConfirmPassword().isEmpty() && !form.getPassword().isEmpty() && !form.getPassword().equals(form.getConfirmPassword())){
			result.rejectValue("confirmPassword", "", "パスワードが一致していません");
		}
		
		if (result.hasErrors()) {
			return "register_user.html";
		}
		User user = new User();
		user.setName(form.getName());
		user.setEmail(form.getEmail());
		user.setZipcode(form.getZipcode());
		user.setAddress(form.getAddress());
		user.setTelephone(form.getTelephone());
		user.setPassword(form.getPassword());
		userService.insert(user);
		return "redirect:/login";
	}
}
