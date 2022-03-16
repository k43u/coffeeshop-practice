package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Topping;
import com.example.repository.ToppingRepojitory;

@Service
@Transactional
public class ItemDetailService {

	@Autowired
	private ToppingRepojitory toppingRepojitory;
	
	public List<Topping> findAll(){
		return toppingRepojitory.findAll();
	}
}
