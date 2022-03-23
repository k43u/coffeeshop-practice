package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@RequestMapping("/url")
	public String index() {
		return "cart_list.html";
	}
	
}
