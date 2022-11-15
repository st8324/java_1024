package day17;

import java.awt.image.TileObserver;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Board {
	//게시글 번호를 위한 클래스 변수
	private static int count = 0;
	//게시글에 필요한 정보
	private String title, content, writer;
	private int views, num;
	private Date date;
	
	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
		++count;
		num = count;
	}
	public Board(int num) {
		this.num = num;
	}
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public String print() {
		return "------------------------\n"
			+ "번호 : " + num + "\n"
			+ "제목 : " + title + "\n"
			+ "내용 : " + content + "\n"
			+ "작성자: " + writer + "\n"
			+ "조회수: " + views + "\n"
			+ "작성일: " + getDate() + "\n"
			+ "------------------------";
	}
	
	@Override
	public String toString() {
		return num + "  " + title + "  " + writer + "  " + views + "  " + getDate();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			//obj가 Integer로 클래스변환이 가능하면 게시글 번호와 obj를 비교
			if(obj instanceof Integer) {
				if(num == (Integer)obj) {
					return true;
				}
			}
			//Integer, Board 클래스가 아니거나 게시글 번호가 다른 경우
			return false;
		}
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public void updateViews() {
		views++;		
	}
	
}
