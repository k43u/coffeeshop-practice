package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Item;

/**
 * itemsテーブルを操作するリポジトリ
 * 
 * @author kashimamiyu
 *
 */
@Repository
public class ItemRepository {

	@Autowired
    private NamedParameterJdbcTemplate template;
   
    private static final RowMapper<Item> ITEM_ROW_MAPPER=(rs,i)->{
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setName(rs.getString("name"));
        item.setImagePath(rs.getString("image_path"));
        item.setPriceM(rs.getInt("price_m"));
        item.setPriceL(rs.getInt("price_l"));
        item.setDescription(rs.getString("description"));
 
        return item;
 
    };
    
    /**
     * 全件取得
     * 
     * @return 商品リスト
     */
    public List<Item> findAll(){
    	String sql = "SELECT id,name,image_path,price_m,price_l,description"
    			+ " FROM items ORDER BY  price_m  ASC ;";
    	List<Item> itemList = template.query(sql, ITEM_ROW_MAPPER);
    	return itemList;
    }
    
    public Item load(Integer id) {
    	String sql = "SELECT id,name,price_m,price_l,image_path,description FROM items WHERE id=:id;";
    	SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
    	Item item = template.queryForObject(sql, param, ITEM_ROW_MAPPER);
    	return item;
    }
}
