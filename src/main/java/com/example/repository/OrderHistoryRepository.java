package com.example.repository;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;
import com.example.domain.Order;
import com.example.domain.OrderItem;

@Repository
public class OrderHistoryRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final ResultSetExtractor<List<Order>> ORDERITEM_RESULT_SET_EXTRACTOR = (rs) -> {
		List<Order> orderList = new ArrayList<>();
		List<OrderItem> orderItemList = null;
		int beforeIdNum = 0;
		
		while(rs.next()) {
			int nowIdNum = rs.getInt("ord_id");
			
			if (nowIdNum != beforeIdNum) {
				Order order = new Order();
				order.setStatus(rs.getInt("ord_status"));
				order.setOrderDate(rs.getDate("ord_order_date"));
				order.setId(rs.getInt("ord_id"));
				order.setTotalPrice(rs.getInt("ord_total_price"));
				orderItemList = new ArrayList<OrderItem>();
				order.setOrderItemList(orderItemList);
				orderList.add(order);
			}
			
			if (rs.getInt("ori_id") != 0) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(nowIdNum);
				orderItem.setQuantity(rs.getInt("ori_quantity"));
				char[] c = rs.getString("ori_size").toCharArray();
				orderItem.setSize(c[0]);

				Item item = new Item();
				item.setName(rs.getString("itm_name"));
				item.setPriceM(rs.getInt("itm_price_m"));
				item.setPriceL(rs.getInt("itm_price_l"));
				item.setImagePath(rs.getString("itm_image_path"));
				item.setId(rs.getInt("itm_id"));
				orderItem.setItem(item);
				orderItemList.add(orderItem);
			}

		  beforeIdNum = nowIdNum;
		}
		return orderList;
	  };
			
	  public	List<Order> findOrderHistory(int userId){
			String	sql="SELECT ord.status ord_status,ord.total_price ord_total_price,ord,ord.order_date ord_order_date,"
			+" ord.id ord_id,ori.id ori_id,ori.quantity ori_quantity,ori.size ori_size,itm.name itm_name,itm.id itm_id,itm.price_m itm_price_m,itm.price_l itm_price_l,itm.image_path itm_image_path "
			+ "FROM orders ord "
			+ "JOIN order_items ori ON ord.id=ori.order_id "
			+ "JOIN items itm ON ori.item_id = itm.id "
			+ "WHERE ord.user_id=:userId AND (ord.status=1 OR ord.status=2);";


			
			SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId);
			List<Order> orderList = template.query(sql,param,ORDERITEM_RESULT_SET_EXTRACTOR);
			return orderList;
		}
		
			
		
}
