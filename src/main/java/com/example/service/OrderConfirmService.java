package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.domain.OrderItem;
import com.example.repository.OrderRepository;

@Service
@Transactional
public class OrderConfirmService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderItem> findOrderItemList(Integer userId){
		return orderRepository.findOrderItemList(userId);
	}
	
	public void destinationUpdate(Order order) {
		orderRepository.destinationUpdate(order);
	}
}
