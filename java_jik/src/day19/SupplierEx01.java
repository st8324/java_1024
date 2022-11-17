package day19;

import java.util.function.Supplier;

public class SupplierEx01 {

	public static void main(String[] args) {
		System.out.println(num(()->(int)(Math.random()*10)));
	}
	
	public static int num(Supplier<Integer> s) {
		return s.get();
	}
}
