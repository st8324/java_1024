package day27;

import java.net.InetSocketAddress;
import java.net.Socket;

public class Ex01_Client {

	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[연결 시도 중]");
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
		}catch(Exception e) {
			System.out.println("[연결 실패]");
		}

	}

}
