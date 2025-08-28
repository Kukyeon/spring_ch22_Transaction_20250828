<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 카드 결제</title>
</head>
<body>
	<h2>상품 카드 결제</h2>
	<hr>
	<form action="payOk">
		상품 ID : <input type="text" name="productid"> <br>
		상품 수량 : <input type="number" name="quantity"> <br>
		<input type="submit" value="결제하기">
	</form>
</body>
</html>