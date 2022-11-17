package day19;

import java.util.function.Consumer;

public class LambdaEx02 {

	public static void main(String[] args) {
		Sum sum = (a,b)-> a + b;
		System.out.println(sum.run(1, 2));
		Print<String> print = num->System.out.println(num);
		print.run("10");
		Consumer<String> print2 = str->System.out.println(str);
		print2.accept("10");
	}
}

interface Sum{
	double run(double a, double b);
}
interface Print<T>{
	void run(T num);
}