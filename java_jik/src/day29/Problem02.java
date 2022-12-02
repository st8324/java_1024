package day29;

import lombok.Data;

public class Problem02 {

	public static void main(String[] args) {
		/* 아래 코드는 에러가 발생하는데, 원인과 해결방안을 설명하세요. 
		 * 원인 : 매개변수로 정수를 필요로 하는 생성자가 없기 때문에 에러 발생
		 *       public void Board1(int num)는 생성자가 아니라 메소드
		 * 해결 방안 : Board1메소드를 생성자로 수정(void를 제거)
		 * */
		//Board1 board = new Board1(1);

	}

}
@Data
class Board1{
	int num;
	public void Board1(int num) {
		this.num = num;
	}
}
