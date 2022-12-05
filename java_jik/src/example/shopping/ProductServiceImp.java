package example.shopping;

import java.util.List;
import java.util.Scanner;

public class ProductServiceImp implements ProductService {

	@Override
	public boolean insertProduct(List<Product> productList, Product product) {
		//매개변수 예외 체크
		if(productList == null || product == null)
			return false;
		//이미 등록된 제품인지 확인
		if(productList.contains(product)) {
			return false;
		}
		//제품 등록
		productList.add(product);
		return true;
	}

	@Override
	public boolean updateProduct(List<Product> productList,int index, Product product) {
		//매개변수 예외 체크
		if(productList == null || productList.size() == 0 
			|| index < 0 || product == null)
			return false;
		//수정
		productList.set(index, product);
		return true;
	}

	@Override
	public boolean deleteProduct(List<Product> productList, Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProduct(List<Product> productList, int index) {
		//매개변수 예외 체크
		if(productList == null || index < 0 
			|| productList.size() <= index)
			return null;
		
		return productList.get(index);
	}

	@Override
	public void productStock(Product product, int amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product inputProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.print("분류 : ");
		String type = scan.nextLine();
		System.out.print("제품명 : ");
		String title = scan.nextLine();
		System.out.print("구매가 : ");
		int buyPrice = scan.nextInt();
		System.out.print("판매가 : ");
		int sellPrice = scan.nextInt();
		if(buyPrice > sellPrice)
			return null;
		return new Product(type, title, buyPrice, sellPrice);
	}
	
}
