package day23;

import java.io.File;
import java.io.IOException;

public class FileEx01 {

	public static void main(String[] args) {
		File f = new File("C:/Users/user2/Downloads/test.txt");
		try {
			if(f.createNewFile()) {
				System.out.println("파일이 생성되었습니다.");
			}else {
				System.out.println("파일 생성에 실패했습니다.");
			}
		}catch(IOException e) {
			System.out.println("IOException이 발생했습니다.");
		}

	}

}
