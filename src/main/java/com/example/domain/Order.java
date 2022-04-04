package com.example.domain;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author kashimamiyu
 *
 *注文を表すドメイン
 */

public class Order {

	private Integer id;
	private Integer userId;
	private Integer status;
	private Integer totalPrice;
	private Date orderDate;
	private String destinationName;
	private String destinationEmail;
	private String destinationZipcide;
	private String destinationAddress;
	private String destinationTel;
	private Timestamp deliveryTime;
	private Integer paymentMethod;
	User user;
	List<OrderItem> orderItemList;
	
	public Integer getId() {
		return id;
	}
	public Integer getUserId() {
		return userId;
	}
	public Integer getStatus() {
		return status;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public String getDestinationEmail() {
		return destinationEmail;
	}
	public String getDestinationZipcide() {
		return destinationZipcide;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public String getDestinationTel() {
		return destinationTel;
	}
	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}
	public Integer getPaymentMethod() {
		return paymentMethod;
	}
	public User getUser() {
		return user;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}
	public void setDestinationZipcide(String destinationZipcide) {
		this.destinationZipcide = destinationZipcide;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public void setDestinationTel(String destinationTel) {
		this.destinationTel = destinationTel;
	}
	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public int getTax() {
		int tax = 0;
		for(OrderItem orderItem :orderItemList) {
			tax+=orderItem.getSubTotal();
		}
		tax*=0.1;
		return tax;
		}
	
	public int getCalcTotalPrice() {
		int total=0;
		for(OrderItem orderItem :orderItemList) {
			total+=orderItem.getSubTotal();
		}
		total*=1.1;
		return total;
		}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", status=" + status + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", destinationName=" + destinationName + ", destinationEmail="
				+ destinationEmail + ", destinationZipcide=" + destinationZipcide + ", destinationAddress="
				+ destinationAddress + ", destinationTel=" + destinationTel + ", deliveryTime=" + deliveryTime
				+ ", paymentMethod=" + paymentMethod + ", user=" + user + ", orderItemList=" + orderItemList + "]";
	}

	
	
	
}
