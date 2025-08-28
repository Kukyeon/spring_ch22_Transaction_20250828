package com.kkuk.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayService {

	@Autowired
	private PayDao payDao;
	
	@Transactional
	public void ProcessPayment(int productid, int quantity) {
		
		int productPrice = 1000;
		
		payDao.insertPayment(productid, quantity, quantity*productPrice);
		payDao.reduceStock(productid, quantity);
		
	}
	
}
