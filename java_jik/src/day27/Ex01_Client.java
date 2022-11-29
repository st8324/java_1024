package day27;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_Client {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 시도 중]");
			socket.connect(new InetSocketAddress("192.168.10.6", 5001));
			System.out.println("[연결 성공]");
			send(socket);
			
		}catch(Exception e) {
			System.out.println("[연결 실패]");
		}

	}
	public static void recieve(Socket socket) {
		
	}
	public static void send(Socket socket) {
		Thread t = new Thread(()->{
			Scanner scan = new Scanner(System.in);
			try {
				OutputStream os = socket.getOutputStream();
				while(true) {
					String str = scan.nextLine();
					if(str.equals("exit")) {
						if(socket != null && !socket.isClosed())
							socket.close();
						os.close();
						break;
					}
					byte [] bytes = str.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}
			}catch (Exception e) {
				
			}finally {
				System.out.println("종료");
				try {
					if(socket != null && !socket.isClosed())
						socket.close();
				}catch(Exception e) {
					
				}
			}
		});
		t.start();
	}
}
