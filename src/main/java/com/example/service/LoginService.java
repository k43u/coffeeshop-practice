package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.OrderItem;
import com.example.repository.OrderItemRepository;
import com.example.repository.OrderRepository;

@Service
@Transactional
public class LoginService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public OrderItem load(Integer id) {
		return orderItemRepository.load(id);
	}
	
	public void deleteOrder(Integer userId) {
		orderRepository.deleteOrder(userId);
	}
	
	public void updateOrder(Integer userId, Integer preId) {
		orderRepository.updateOrder(userId, preId);
	}
}
