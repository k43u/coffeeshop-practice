package com.example.domain;

/**
 * @author kashimamiyu
 * 
 * ユーザーを表すドメイン
 *
 */
public class User {
 
	private Integer id;
	private String name;
	private String email;
	private String password;
	private String zipcode;
	private String address;
	private String telephone;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getAddress() {
		return address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", zipcode="
				+ zipcode + ", address=" + address + ", telephone=" + telephone + "]";
	}
}
