package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.OrderItem;
import com.example.domain.OrderTopping;
import com.example.domain.Topping;
import com.example.repository.OrderItemRepository;	
import com.example.repository.ToppingRepojitory;


@Service
@Transactional
public class ItemDetailService {

	@Autowired
	private ToppingRepojitory toppingRepojitory;
	
	@Autowired
	private OrderItemRepository orderItemrepository;
    
	
	public List<Topping> findAll(){
		return toppingRepojitory.findAll();
	}
	
	public void insertTopping(OrderTopping orderTopping) {
    	toppingRepojitory.insert(orderTopping);
    }
    
    public OrderItem load(Integer id) {
    	return orderItemrepository.load(id);
    }
    
    public int insertOrderItem(OrderItem orderItem) {
    	return orderItemrepository.insert(orderItem);
    }
    
    public int insertOrder(Integer userId) {
    	return orderItemrepository.insertOrder(userId);
    }
    
	
}
