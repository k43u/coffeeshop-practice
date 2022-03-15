package com.example.form;

/**
 * @author kashimamiyu
 *
 * ユーザー登録時に使用するフォーム
 */
public class UserRegisterForm {

	/**名前*/
	private String name;
	/**メールアドレス*/
	private String email;
	/**郵便番号*/
	private String zipcode;
	/**住所*/
	private String address;
	/**電話番号*/
	private String telephone;
	/**パスワード*/
	private String password;
	/**確認用パスワード*/
	private String confirmPassword;
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
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
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "UserRegisterForm [name=" + name + ", email=" + email + ", zipcode=" + zipcode + ", address=" + address
				+ ", telephone=" + telephone + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
}
