package example.shopping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Sales {
	//제품 정보, 수량, 타입(구매/판매), 총금액, 일시
	private Product product;
	private int amount, price;
	private Date date;
	private SalesType type;

	public Sales(Product product, int amount, int price, String date, SalesType type) {
		this.product = product;
		this.amount = amount;
		this.price = price;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = f.parse(date);
		} catch (ParseException e) {
			this.date = null;
		}
		this.type = type;
	}

	public void calculate(String type) {
		if(product == null)
			return;
		int price = 0;
		
		if(SalesType.valueOf(type) == SalesType.구매)
			price = product.getBuyPrice() * amount;
		else if(SalesType.valueOf(type) == SalesType.판매)
			price = product.getSellPrice() * amount;
		
		this.price = price;
	}

	public String getDateStr() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		if(date == null)
			return "";
		return f.format(date);
	}
	
	@Override
	public String toString() {
		return "[ 분류 : " + product.getType() 
			+ " | 제품명 : " + product.getTitle() 
			+ " | " + type.toString() +" 수량 : " + amount 
			+ " | 가격 : " + price 
			+ " | 일시 : " + getDateStr();
	}
	
	
}
enum SalesType{
	판매, 구매
}
