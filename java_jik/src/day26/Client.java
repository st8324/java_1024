package day26;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	private Socket socket;

	public Client(Socket socket) {
		this.socket = socket;
	}
	
	public void read() {
		Thread t = new Thread(()->{
			try {
				InputStream is = socket.getInputStream();
				while(true) {
					byte [] bytes = new byte[1024];
					int readCount = is.read(bytes);
					if(readCount == -1)
						break;
					String str = new String(bytes, 0, readCount, "UTF-8");
					System.out.println(str);
				}
				is.close();
			}catch(Exception e) {
				System.out.println("[클라이언트가 접속을 종료했습니다.]");
			}
		});
		t.start();
	}
	public void send() {
		Scanner scan = new Scanner(System.in);
		Thread t = new Thread(()->{
			try {
				OutputStream os = socket.getOutputStream();
				while(true) {
					System.out.print("전송할 문자열 : ");
					String str = scan.nextLine();
					if(str.equals("exit"))
						break;
					byte [] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
				os.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
}
