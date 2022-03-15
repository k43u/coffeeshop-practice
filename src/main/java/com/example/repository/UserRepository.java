package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * @author kashimamiyu
 * 
 * usersテーブルを操作するリポジトリです。
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setZipcode(rs.getString("zipcode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};
	
	/**
	 * @param user
	 * 
	 * ユーザー情報を挿入する
	 */
	public void insert(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		String sql = "INSERT INTO users(name,email,zipcode,address,telephone,password) "
				+ "VALUES(:name,:email,:zipcode,:address,:telephone,:password);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	}
	/**
	 * @param email メールアドレス
	 * @param password パスワード
	 * @return ユーザー情報 存在しない場合はnullを返します。
	 */
	public User findByEmailAndPassword(String email, String password) {
		String sql = "SELECT id,name,email,password,zipcode,address,telephone,password from users WHERE email=:email";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		
		if(userList.size() == 0) {
			return null;
		}
		User user = userList.get(0);
		if(!passwordEncoder.matches(password,user.getPassword())) {
			return null;
		}
		return userList.get(0);
	}
	/**
	 * @param email メールアドレス
	 * @return ユーザー情報 存在しない場合はnullを返します。
	 */
	public User findByEmail(String email) {
		String sql = "SELECT id,name,email,password,zipcode,address,telephone,password from users WHERE email=:email;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
}
