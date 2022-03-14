package com.example.domain;

/**
 * @author kashimamiyu
 *
 *注文トッピングを表すドメイン
 */
public class OrderTopping {

	private Integer id;
	private Integer toppingId;
	private Integer orderItemId;
	private Topping topping;
	
	public Integer getId() {
		return id;
	}
	public Integer getToppingId() {
		return toppingId;
	}
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public Topping getTopping() {
		return topping;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setToppingId(Integer toppingId) {
		this.toppingId = toppingId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	public void setTopping(Topping topping) {
		this.topping = topping;
	}
	@Override
	public String toString() {
		return "OrderTopping [id=" + id + ", toppingId=" + toppingId + ", orderItemId=" + orderItemId + ", topping="
				+ topping + "]";
	}
	
}
