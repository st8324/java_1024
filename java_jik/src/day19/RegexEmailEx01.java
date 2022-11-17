package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexEmailEx01 {

	public static void main(String[] args) {
		/* 이메일 주소를 입력받아 이메일 형식이 맞는지 확인하는 코드를 작성하세요.
		 * 단, 정규표현식 이용.
		 * abc123@naver.com
		 * abc123@xxx.or.kr
		 * 
		 * abc123 @ naver.com
		 * [a-zA-Z0-9\-_]+@[a-zA-Z0-9\-]{2,}(\.[a-zA-Z]+){1,2}
		 * */
		String regex ="^[a-zA-Z0-9\\-_]+@[a-zA-Z0-9\\-]{2,}(\\.[a-zA-Z]+){1,2}$";
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		if(Pattern.matches(regex, str)) {
			System.out.println(str+"은 이메일 형식입니다.");
		}else {
			System.out.println(str+"은 이메일 형식이 아닙니다.");
		}
		
		scan.close();
	}

}
