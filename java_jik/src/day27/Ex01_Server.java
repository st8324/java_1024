package day27;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Ex01_Server {

	private static ArrayList<Client> clientList = new ArrayList<Client>();
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress(5001));
			System.out.println("[서버 시작]");
			while(true) {
				Socket socket = serverSocket.accept();
				Client client = new Client(socket);
				client.recieve();
				clientList.add(client);
				System.out.println("[클라이언트 접속] - 현재 접속 인원 : " + clientList.size());
			}
		}catch(Exception e) {
			System.out.println("예외 발생 : 서버 종료!");
		}
	}
	static class Client {
		
		private Socket socket;
		
		public Client(Socket socket) {
			this.socket = socket;
		}
		public void recieve() {
			Thread t = new Thread(()->{
				InputStream is = null;
				try {
					byte [] bytes = new byte[1024];
					is = socket.getInputStream();
					/* read() : 1바이트를 읽어와서 정수로 알려줌
					 * read(byte[] bytes) : bytes 크기만큼 한번에 읽어 와서,
					 *   bytes 배열에 저장하고, 읽어온 갯수를 정수로 알려줌
					 * */
					while(true) {
						int readCount = is.read(bytes);
						//byte[]에 있는 byte들을 문자열로 변환, 0번지부터
						//readCount 개수만큼 변환하는데 인코딩은 UTF-8
						if(readCount == -1)
							break;
						String str = new String(bytes, 0, readCount, "UTF-8");
						//다른 클라이언트들에게 str을 전송
						System.out.println(str);
					}
					is.close();
					System.out.println(123);
				}catch(Exception e) {
					
				}finally {
					//읽기 위해서 대기하다 예외가 발생하면 socket을 닫아 줌
					//=>클라이언트에서 접속을 종료 함
					try {
						if(socket != null && socket.isClosed())
							socket.close();
						//클라이언트 리스트에서 접속 종료한 클라이언트를 제거
						clientList.remove(this);
						System.out.println("[클라이언트 종료] - 현재 접속 인원 : " + clientList.size());
					}catch(Exception e2) {
						System.out.println("클라이언트 소켓 닫기 실패");
					}
				}
			});
			t.start();
		}
		public void send(String data) {
			Thread t = new Thread(()->{
				OutputStream os = null;
				try {
					os = socket.getOutputStream();
					byte [] bytes = data.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
				}catch(Exception e) {
					System.out.println("서버 예외 발생!!");
				}
			});
			t.start();
		}
	}
}




