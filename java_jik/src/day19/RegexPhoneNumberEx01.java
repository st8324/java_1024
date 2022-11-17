package day19;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexPhoneNumberEx01 {

	public static void main(String[] args) {
		/* 전화번호 정규표현식을 작성하여 입력받은 번호가 전화번호가 맞는지 출력하는 코드를
		 * 작성하세요.
		 * 규칙1.
		 * 010-1234-5678 [o]
		 * 01012345678 [x]
		 * 011-1234-5678 [x]
		 * 
		 * 010-[0-9]{4}-[0-9]{4}
		 * 010-\d{4}-\d{4}
		 * 010(-\d{4}){2}
		 * */
		String regex ="010(-\\d{4}){2}";
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		if(Pattern.matches(regex, str)) {
			System.out.println(str+"은 휴대폰 번호입니다.");
		}else {
			System.out.println(str+"은 휴대폰 번호 형식이 아닙니다.");
		}
		
		scan.close();

	}

}
