package day23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamEx01 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream("test.txt");
			char ch = '\u0000';
			for(int i = 0; i<200; i++) {
				//System.out.print(ch);
				fos.write(ch);
				++ch;
			}
			fis = new FileInputStream("test.txt");
			int num;
			for(int i = 0; i<200; i++) {
				num = fis.read();
				System.out.print((char)num);
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
