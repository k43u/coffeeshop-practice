package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Order;
import com.example.repository.OrderHistoryRepository;

@Service
@Transactional
public class OrderHistoryService {

	@Autowired
    private OrderHistoryRepository repository;
	
	public  List<Order> findOrderHistory(int userId){
        return repository.findOrderHistory(userId);
    }

}
