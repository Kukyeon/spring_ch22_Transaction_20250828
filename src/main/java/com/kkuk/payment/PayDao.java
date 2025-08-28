package com.kkuk.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PayDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//결제 내역 DB에 저장하는 메서드
	public void insertPayment(int productid, int quantity, int payamount) {
		String sql = "INSERT INTO payment(productid, quantity, payamount) VALUES (?,?,?) ";
		jdbcTemplate.update(sql, productid, quantity, payamount);
	}
	
	//결제 내역에 따라 재고 차감하는 메서드
	public void reduceStock(int productid, int quantity) {
		String sql = "UPDATE product SET pstock = pstock - ? WHERE productid = ?";
		int result = jdbcTemplate.update(sql, quantity, productid);
		//업데이트가 완료된 레코드의 수가 봔환, 실패가0  성공이 0
		
		if(result == 0) {
			throw new RuntimeException("상품 재고 수량 에러");
		}
	}
	
}

