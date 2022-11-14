package day16;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx01 {

	public static void main(String[] args) {
		HashMap<String, String> userList = new HashMap<String, String>();
		userList.put("id1", "pw1");
		userList.put("id2", "pw2");
		userList.put("id3", "pw2");
		userList.put("id3", "pw3");
		System.out.println(userList);
		
		//방법1. keySet을 이용
		//keySet()은 map에 있는 key들을 하나의 set에 담아 반환하는 메소드
		Set<String> keySet = userList.keySet();
		for(String tmp : keySet) {
			System.out.println(tmp + " : " + userList.get(tmp));
		}
		//방법2. EntrySet을 이용
		Set<Entry<String, String>> entrySet = userList.entrySet();
		for(Entry<String, String> tmp : entrySet) {
			System.out.println(tmp.getKey() + " : " + tmp.getValue());
		}
	}
}
