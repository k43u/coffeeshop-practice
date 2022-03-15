package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * @author kashimamiyu
 *
 *ユーザー情報を操作するサービス
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * @param user
	 * 
	 * ユーザー情報を挿入する
	 */
	public void insert(User user) {
		userRepository.insert(user);
	}
	
	/**
	 * @param email
	 * @param password
	 * @return ユーザー情報
	 * 
	 * メールアドレスとパスワードからユーザー情報を取得
	 */
	public User login(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return user;
	}
	
	/**
	 * メールアドレスからユーザー情報を取得
	 * 
	 * @param email メールアドレス
	 * @return ユーザー情報
	 */
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}
