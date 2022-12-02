package day29;

import lombok.Data;

public class Problem03 {

	public static void main(String[] args) {
		/* 게시글 제목에 공지가 있는지 확인하는 코드입니다. 아래 코드 결과를 작성하고, 왜 그렇게
		 * 결과가 나오는지 설명하세요. 원래 목적에 맞게 동작시키려면 어느 부분을 수정해야 하는지
		 * 작성하고 수정하는 코드를 작성하세요.
		 * 결과
		 * 제목에 공지가 포함되어 있지 않습니다.
		 * 이유 :게시글 제목과 검색어를 비교하려면, board2가 아닌 board2의 제목과 비교해야 함. 
		 * board2.equals(search) : 
		 *   - 게시글 전체와 검색어 search와 비교를 하는데,
		 *     Board2 클래스에 equals는 title과 contents가 모두 같은때만 동작하고,
		 *     비교 대상이 다른 클래스인 경우 무조건 false를 리턴 
		 * 수정
		 * board2.equals(search)를 board2.getTitle().contains(search)
		 *   
		 * */
		Board2 board2 = new Board2();
		board2.setTitle("공지사항");
		String search = "공지";
		if(board2.equals(search)) {
			System.out.println("제목에 공지가 포함되었습니다.");
		}else {
			System.out.println("제목에 공지가 포함되어 있지 않습니다.");
		}
	}

}

@Data
class Board2{
	String title, contents;
}