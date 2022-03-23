package com.example.repository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Order;
import com.example.domain.OrderItem;

@Repository
public class OrderItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<OrderItem> ORDERITEM_ROW_MAPPER = (rs,i) -> {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(rs.getInt("id"));
		return orderItem;
	};
	
	private static final RowMapper<Order> ORDER_ROW_MAPPER = (rs,i) -> {
	    Order order = new Order();
	    order.setId(rs.getInt("id"));
	    return order;
	};
	
	/**
	 * @param id
	 * @return 注文商品
	 */
	public OrderItem load(Integer id) {
		OrderItem orderItem = new OrderItem();
		String sql = "SELECT id  FROM orders WHERE user_id=:userId AND status = 0;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",id);
		List<Order> orderList = template.query(sql, param,ORDER_ROW_MAPPER);
		if(orderList.size() == 0) {
			orderItem = null;
			return orderItem;
		}
		Order order = orderList.get(0);
		orderItem.setOrderId(order.getId());
		return orderItem;
	}
	
	/**
	 * @param orderItem
	 * @return 注文商品のId
	 */
	public int insert(OrderItem orderItem) {
		String sql = "INSERT INTO order_items(item_id,order_id,quantity,size) VALUES (:itemId,:orderId,:quantity,:size) RETURNING id;";
		SqlParameterSource param=new MapSqlParameterSource().addValue("orderId", orderItem.getOrderId()).addValue("itemId", orderItem.getItemId()).addValue("quantity", orderItem.getQuantity()).addValue("size",orderItem.getSize());
        OrderItem orderItemId=template.queryForObject(sql,param,ORDERITEM_ROW_MAPPER);
        return orderItemId.getId();
	}
	
	/**
	 * @param userid
	 * @return 注文のId
	 */
	public int insertOrder(Integer userid) {
    	String sql="INSERT INTO orders(user_id,status,total_price) values(:userId,0,0) RETURNING id;";
    	SqlParameterSource param=new MapSqlParameterSource().addValue("userId", userid);
    	Order orderId = template.queryForObject(sql,param,ORDER_ROW_MAPPER);
    	return orderId.getId();
     }
	
}
