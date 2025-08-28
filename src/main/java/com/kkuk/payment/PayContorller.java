package com.kkuk.payment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PayContorller {

	@Autowired
	private PayService payService;
	
	
	@RequestMapping(value = "/payForm")
	public String pay() {
		return "pay";
	}
	
	@RequestMapping(value = "/payOk")
	public String payOk(HttpServletRequest request, Model model) {
		
		int productid = Integer.parseInt(request.getParameter("productid")); // 제품 아이디
		int quantity = Integer.parseInt(request.getParameter("quantity")); // 제품 수량
		
//		PayDao payDao = new PayDao();
//		payDao.insertPayment(productid, quantity, quantity*1000);
//		payDao.reduceStock(productid, quantity);
		
		payService.ProcessPayment(productid, quantity);
		
		return "pay";
	}
}
