package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping("/shoppingList")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("")
	public String index(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList",itemList);
		return "item_list_coffee";
	}
	
	@RequestMapping("/orderBy")
    public String index(String select,Model model){
        if(select.equals("low")){
            List<Item> itemList=itemService.findAll();
        model.addAttribute("itemList", itemList);
        }else if(select.equals("high")){
            List<Item> itemList=itemService.findAllDesc();
            model.addAttribute("itemList", itemList);
        }
        return "item_list_coffee";
    }
	
	@RequestMapping("/searchWord")
    public String findByLikeWord(String searchWord,String select,Model model){
    	if(select==null) {
    		return "forward:/shoppingList";
    	}
        if(select.equals("low")){
            List<Item> itemList=itemService.findByLikeName(searchWord);
            if(itemList.size()==0){
                String nullMessage="該当する商品がありません";
                model.addAttribute("nullMessage", nullMessage);
        		model.addAttribute("searchWord",searchWord);
                return index(model);
            }else{
                model.addAttribute("itemList", itemList);
        		model.addAttribute("searchWord",searchWord);
                return "item_list_coffee";
 
            }
        }else if(select.equals("high")){
            List<Item> itemListD=itemService.findByLikeNameDesc(searchWord);
            if(itemListD.size()==0){
                String nullMessage="該当する商品がありません";
                model.addAttribute("nullMessage", nullMessage);
        		model.addAttribute("searchWord",searchWord);
                return index(model);
            }else{
                model.addAttribute("itemList", itemListD);
        		model.addAttribute("searchWord",searchWord);
                return "item_list_coffee";
            }
        }else{
            return "forward:/shoppingList";
        }
       
       
    }
}
