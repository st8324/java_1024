package day23;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreamEx02 {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("test.txt");
			
			char ch = '\u0000';
			for(int i = 0; i<200; i++)
				fw.write(ch++);
			fw.close();
			
			
			fr = new FileReader("test.txt");
			for(int i = 0; i<200; i++) {
				int num = fr.read();
				System.out.print((char)num);
			}
			fr.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
