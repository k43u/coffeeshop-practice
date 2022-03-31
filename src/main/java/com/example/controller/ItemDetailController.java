package com.example.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.domain.OrderItem;
import com.example.domain.OrderTopping;
import com.example.domain.Topping;
import com.example.form.OrderItemForm;
import com.example.service.ItemDetailService;
import com.example.service.ItemService;

@Controller
@RequestMapping("/itemDetail")
public class ItemDetailController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDetailService itemDetailService;
	
	@ModelAttribute
	public OrderItemForm setUpOrderItemForm() {
		return new OrderItemForm();
	}
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
    public  String index(String id,Model model){
        Item item=itemService.load(Integer.parseInt(id));
        if(item.getName()==null){
            return "redirect:/shoppingList";

        }
        List<Topping> toppingList = itemDetailService.findAll();
        model.addAttribute("item",item);
        model.addAttribute("toppingList",toppingList);
        return "item_detail";
    }
	
	@RequestMapping("/insert")
	public String insert(OrderItemForm form) {
		
		Integer userId = (Integer) session.getAttribute("userId");
		Integer preId = (Integer) session.getAttribute("preId");
		int orderId = 0;
		int orderItemId = 0;
		
		if(userId != null) {
			OrderItem orderItem = itemDetailService.load(userId);
			if(orderItem != null) {
				orderItem.setItemId(form.getItemId());
				orderItem.setQuantity(form.getQuantity());
				char[] c = form.getSize().toCharArray();
				orderItem.setSize(c[0]);
				orderItemId = itemDetailService.insertOrderItem(orderItem);
			}else {
				orderId = itemDetailService.insertOrder(userId);
				OrderItem orderItem2  = new OrderItem();
				orderItem2.setOrderId(orderId);
				orderItem2.setItemId(form.getItemId());
				orderItem2.setQuantity(form.getQuantity());
				char[] c  = form.getSize().toCharArray();
				orderItem2.setSize(c[0]);
				orderItemId = itemDetailService.insertOrderItem(orderItem2);

			}
		}else if (userId == null) {
			if(preId != null) {
				OrderItem orderItem = itemDetailService.load(preId);
				orderItem.setItemId(form.getItemId());
				orderItem.setQuantity(form.getQuantity());
				char[] c = form.getSize().toCharArray();
				orderItem.setSize(c[0]);
				orderItemId = itemDetailService.insertOrderItem(orderItem);
			}else if (preId == null) {
				int uuid = Math.abs(UUID.randomUUID().hashCode());
				session.setAttribute("preId", uuid);
				orderId = itemDetailService.insertOrder(uuid);
				OrderItem orderItem = new OrderItem();
				orderItem.setItemId(form.getItemId());
				orderItem.setOrderId(orderId);
				orderItem.setQuantity(form.getQuantity());
				char[] c = form.getSize().toCharArray();
				orderItem.setSize(c[0]);
				orderItemId = itemDetailService.insertOrderItem(orderItem);
			}
			
		}
		
		if(form.getOrderToppings() == null) {
			return "redirect:/shoppingCart";
		}
		
		for(String topping : form.getOrderToppings()) {
			Integer toppingId = Integer.parseInt(topping);
			OrderTopping orderTopping = new OrderTopping();
			orderTopping.setToppingId(toppingId);
			orderTopping.setOrderItemId(orderItemId);
			itemDetailService.insertTopping(orderTopping);
		}
		
		
		return "redirect:/shoppingCart";
	}
	
	
}
