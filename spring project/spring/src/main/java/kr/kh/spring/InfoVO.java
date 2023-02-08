package kr.kh.spring;


public class InfoVO {
	private String name;
	private int num;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "InfoVO [name=" + name + ", num=" + num + "]";
	}
	
}
