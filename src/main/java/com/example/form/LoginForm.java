package com.example.form;

/**
 * @author kashimamiyu
 *
 * ログイン時に使用するフォーム
 */
public class LoginForm {

	/**メールアドレス */
	private String email;
	/**パスワード */
	private String password;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", password=" + password + "]";
	}
}
