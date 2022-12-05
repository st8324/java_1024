package example.shopping;

import java.util.List;

public class SalesController {
	private List<Sales> salesList;
	private List<Product> productList;
	private ProductService ps;
	private SalesService ss;
	
	public SalesController(List<Sales> salesList, List<Product> productList) {
		this.salesList = salesList;
		this.productList = productList;
		ps = new ProductServiceImp();
		ss = new SalesServiceImp();
	}

	public void sales(String type) {
		//구매할 제품 정보 입력(타입, 제품명, 수량)
		Sales sales = ss.inputSales(type);
		
		//입력한 제품 정보를 가져옴
		Product product = ps.getProduct(productList, sales.getProduct());
		
		if(product == null)
			return;
		
		sales.setProduct(new Product(product));
		int amount = sales.getAmount();
		amount = 
			type.equals("구매") ? amount : -amount; 
		product.addAmount(amount);
		
		//매출 금액을 계산
		sales.calculate(type);
		
		//전체 매출에 현재 매출 정보를 추가
		salesList.add(sales);
	}
	
	
}
