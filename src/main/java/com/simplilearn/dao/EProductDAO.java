package com.simplilearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.pojo.EProduct;

@Repository
public class EProductDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<EProduct> getProducts() {
		return jdbcTemplate.query("select * from eprodudct_12072022", new RowMapper<EProduct>() {

			@Override
			public EProduct mapRow(ResultSet rs, int arg1) throws SQLException {
				EProduct product = new EProduct();
				product.setEproductId(rs.getLong(1));
				product.setEproductName(rs.getString(2));
				product.setEproductPrice(rs.getLong(3));
				return product;
			}
		});
	}
}
