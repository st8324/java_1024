package day26;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex01_ServerMain {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Scanner scan = new Scanner(System.in);
		final String encode = "UTF-8";
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			while(true) {
				System.out.println("[연결 대기 중]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa 
					= (InetSocketAddress)socket.getRemoteSocketAddress();
				System.out.println("[연결 수락 함] " + isa.getAddress());
				InputStream is = socket.getInputStream();
				byte []bytes = new byte[1024];
				int readCount = is.read(bytes);
				String str = new String(bytes, 0, readCount,encode);
				System.out.println(str);
				//콘솔에서 문자열을 입력받아 
				//클라이언트로 전송
				OutputStream os = socket.getOutputStream();
				str = scan.nextLine();
				bytes = str.getBytes(encode);
				os.write(bytes);
				os.flush();
				System.out.println("[전송 완료]");
				is.close();
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
