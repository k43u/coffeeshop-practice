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

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String findorderitemliList(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		Integer preId = (Integer) session.getAttribute("preId");
		List<OrderItem> orderItemList = null;
		HashMap<Integer, Integer> totalMap = new HashMap<>();
		
		if(userId == null && preId == null) {
			orderItemList= null;
			model.addAttribute("errorMessage","カートに商品がありません");
			return "cart_list.html";
		}
		
		if(userId == null) {
			orderItemList = cartService.findOrderItemList(preId);
		}else if(preId == null) {
			orderItemList = cartService.findOrderItemList(userId);
		}
		
		for(OrderItem orderItem : orderItemList) {
			totalMap.put(orderItem.getId(),orderItem.getSubTotal());
		}
		
		Order order = new Order();
		order.setOrderItemList(orderItemList);
		
		if(orderItemList.size() == 0) {
			orderItemList = null;
			model.addAttribute("errorMessage","カートに商品がありません");
		}
		
		model.addAttribute("orderItemList",orderItemList);
		model.addAttribute("totalMap",totalMap);
		model.addAttribute("tax", order.getTax());
		model.addAttribute("total",order.getCalcTotalPrice());
		return "forward:/shoppingCart/url";
	}

	@RequestMapping("/url")
	public String index() {
		return "cart_list.html";
	}
	
	@RequestMapping("/delete")
	public String delete(int deleteId, Model model) {
		int itemId = deleteId;
		cartService.deleteCart(itemId);
		return "redirect:/shoppingCart";
	}
	
}
