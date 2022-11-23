package day23;

import java.io.*;

public class FileStreamEx03 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("test.txt");
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("홍길동");
			dos.writeUTF("2000-01-01");
			
			dos.writeUTF("임꺽정");
			dos.writeUTF("2000-02-02");
			
			dos.writeUTF("고길동");
			dos.writeUTF("2000-03-03");
			
			while(true) {
				String name = dis.readUTF();
				String birth = dis.readUTF();
				System.out.println(name + " : " + birth);
			}
		}catch(EOFException e) {
			System.out.println("파일 읽기가 완료되었습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
				dis.close();
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
