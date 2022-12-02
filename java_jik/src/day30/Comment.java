package day30;

import lombok.Data;

/* 필드 : 댓글 번호, 내용, 작성자
 * getter,setter
 * toString
 * 생성자 : 댓글 번호, 내용, 작성자
 * */
@Data
public class Comment {
	private int num;
	private String contents, writer;
	private int boardNum;

	@Override
	public String toString() {
		return num + " | " + writer + " | " + contents; 
	}
	
	public Comment(int num, String contents, String writer, int boardNum) {
		this.num = num;
		this.contents = contents;
		this.writer = writer;
		this.boardNum = boardNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
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
	
}
