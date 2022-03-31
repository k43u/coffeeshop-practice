package com.example.domain;

import java.util.List;

/**
 * @author kashimamiyu
 *
 *注文商品を表すドメイン
 */
public class OrderItem {

	private Integer id;
	private Integer itemId;
	private Integer orderId;
	private Integer quantity;
	private Character size;
	private Item item;
	private List<OrderTopping> orderToppingList;
	
	public Integer getId() {
		return id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Character getSize() {
		return size;
	}
	public Item getItem() {
		return item;
	}
	public List<OrderTopping> getOrderToppingList() {
		return orderToppingList;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public void setSize(Character size) {
		this.size = size;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setOrderToppingList(List<OrderTopping> orderToppingList) {
		this.orderToppingList = orderToppingList;
	}
	
	public int getSubTotal() {
		int subTotal = 0;
		if(size.equals('M')) {
			subTotal=(item.getPriceM()+orderToppingList.size()*200)*quantity;
		}else if(size.equals('L')){
			subTotal=(item.getPriceL()+orderToppingList.size()*300)*quantity;
		}
		return subTotal;	
	}
	
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", quantity=" + quantity
				+ ", size=" + size + ", item=" + item + "]";
	}
	
	
}
