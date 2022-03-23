package com.example.form;

import java.util.List;

public class OrderItemForm {

	private Integer id;
	private Integer itemId;
	private Integer quantity;
	private String size;
	private List<String>orderToppings;
	
	public Integer getId() {
		return id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public String getSize() {
		return size;
	}
	public List<String> getOrderToppings() {
		return orderToppings;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setOrderToppings(List<String> orderToppings) {
		this.orderToppings = orderToppings;
	}
	@Override
	public String toString() {
		return "OrderItemForm [id=" + id + ", itemId=" + itemId + ", quantity=" + quantity + ", size=" + size
				+ ", orderToppings=" + orderToppings + "]";
	}
	
}
