package com.example.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.service.CartService;
import com.example.service.OrderConfirmService;

@Controller
@RequestMapping("/confirm")
public class OrderConfirmController {
	
	@Autowired
	private OrderConfirmService orderConfirmService;
	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpSession session;
	

	@RequestMapping("")
	public String index(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		System.out.println("ユーザーIDです" + userId);

		if(userId == null) {
			return "forward:/login";
		}
		
		List<OrderItem> orderItemList = null;
		HashMap<Integer, Integer> totalMap = new HashMap<>();
		orderItemList = cartService.findOrderItemList(userId);
		
		if(orderItemList.size() == 0) {
			return "forward:/shoppingCart";
		}
		

		for(OrderItem orderItem : orderItemList ) {
			totalMap.put(orderItem.getId(), orderItem.getSubTotal());
		}
		
		Order order = new Order();
		order.setOrderItemList(orderItemList);
		
		model.addAttribute("orderItemList",orderItemList);
		model.addAttribute("totalMap",totalMap);
		model.addAttribute("tax",order.getTax());
		model.addAttribute("total", order.getCalcTotalPrice());
		System.out.println(orderItemList);
		return "order_confirm";
	}
	
	
	
}
