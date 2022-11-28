package day26;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx01 {

	public static void main(String[] args) {
		InetAddress ia = null;
		
		try {
			ia = InetAddress.getByName("localhost");
			System.out.println(ia);
			ia = InetAddress.getByName("www.naver.com");
			System.out.println(ia);
			ia = InetAddress.getLocalHost();//현재 내 PC IP 주소
			System.out.println(ia);
			InetAddress []ias = InetAddress.getAllByName("www.naver.com");
			for(InetAddress tmp : ias) {
				System.out.println(tmp);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
