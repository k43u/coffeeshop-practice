package com.example.domain;

/**
 * @author kashimamiyu
 * 
 * トッピングを表すドメイン
 *
 */
public class Topping {

	private Integer id;
	private String name;
	private Integer priceM;
	private Integer priceL;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getPriceM() {
		return priceM;
	}
	public Integer getPriceL() {
		return priceL;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPriceM(Integer priceM) {
		this.priceM = priceM;
	}
	public void setPriceL(Integer priceL) {
		this.priceL = priceL;
	}
	@Override
	public String toString() {
		return "Topping [id=" + id + ", name=" + name + ", priceM=" + priceM + ", priceL=" + priceL + "]";
	}
	
}
