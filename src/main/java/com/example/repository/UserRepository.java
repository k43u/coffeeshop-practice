package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
		String sql = "INSERT INTO users(name,email,zipcode,address,telephone,password) "
				+ "VALUES(:name,:email,:zipcode,:address,:telephone,:password);";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	}
	
	/**
	 * @param email
	 * @param password
	 * @return
	 * 
	 * メールアドレスとパスワードからユーザー情報を検索する
	 */
	public User findByEmailAndPassword(String email, String password) {
		String sql = "SELECT id,name,email,password,zipcode,address,telephone,password FROM users WHERE email=:email"
				+ "AND password=:password;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		
		if(userList.size() == 0) {
			return null;
		}
		
		return userList.get(0);
	}
}
