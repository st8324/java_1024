package day02;

public class EscapeEx01 {
	
	public static void main(String[] args) {
		char ch1 = '\t';
		char ch2 = '\n';
		char ch3 = '\\';
		char ch4 = '\'';
		char ch5 = '\"';
		char ch6 = '\u002B';//002B는 16진수로 10진수 43에 해당
		System.out.println(ch1 + "안녕하세요.");
		System.out.println(ch2 + "안녕하세요.");
		System.out.println(ch3 + "안녕하세요.");
		System.out.println(ch4 + "안녕하세요.");
		System.out.println(ch5 + "안녕하세요.");
		System.out.println(ch6 + "안녕하세요.");
				
	}
}
