package com.example.domain;

import java.util.List;

/**
 * @author kashimamiyu
 *
 *商品を表すドメイン
 */
public class Item {

	private Integer id;
	private String name;
	private String description;
	private Integer priceM;
	private Integer priceL;
	private String imagePath;
	private Boolean deleted;
	private List<Topping> toppingList;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Integer getPriceM() {
		return priceM;
	}
	public Integer getPriceL() {
		return priceL;
	}
	public String getImagePath() {
		return imagePath;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public List<Topping> getToppingList() {
		return toppingList;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPriceM(Integer priceM) {
		this.priceM = priceM;
	}
	public void setPriceL(Integer priceL) {
		this.priceL = priceL;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public void setToppingList(List<Topping> toppingList) {
		this.toppingList = toppingList;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", priceM=" + priceM + ", priceL="
				+ priceL + ", imagePath=" + imagePath + ", deleted=" + deleted + "]";
	}
	
}
