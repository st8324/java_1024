package example.shopping;

import java.util.Scanner;

public class SalesServiceImp implements SalesService {

	@Override
	public Sales inputSales(String saleType) {
		Scanner scan = new Scanner(System.in);
		System.out.print("일시 : ");
		String date = scan.nextLine();
		System.out.print("분류 : ");
		String type = scan.nextLine();
		System.out.print("제품명 : ");
		String title = scan.nextLine();
		System.out.print("수량 : ");
		int amount = scan.nextInt();
		if(amount <= 0) 
			return null;
		Product product = new Product(type, title, 0, 0);
		Sales sales = 
			new Sales(product, amount, 0, date, SalesType.valueOf(saleType));
		return sales;
	}

}
