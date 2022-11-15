package day17;

import lombok.Data;

@Data
public class Member {
	public Member(String pw, String name, String residentNumber, int age) {
		this.pw = pw;
		this.name = name;
		this.residentNumber = residentNumber;
		this.age = age;
	}
	private String pw, name, residentNumber;
	private int age;
	public void update(String newPw, String name, String residentNumber, int age) {
		this.pw = newPw;
		this.name = name;
		this.residentNumber = residentNumber;
		this.age = age;
	}
	
}
