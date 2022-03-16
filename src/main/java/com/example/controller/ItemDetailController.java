package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.domain.Topping;
import com.example.service.ItemDetailService;
import com.example.service.ItemService;

@Controller
@RequestMapping("/itemDetail")
public class ItemDetailController {

	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDetailService itemDetailService;
	
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
	
}
