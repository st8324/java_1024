package day17;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManagerMain {

	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 게시글 관리 프로그램을 작성하세요.
		 * 1. 게시글 작성
		 * 2. 게시글 조회
		 * 3. 게시글 수정
		 * 4. 게시글 삭제
		 * 5. 프로그램 종료
		 * - 게시글은 번호, 제목, 내용, 작성자, 작성일, 조회수로 구성
		 * - 게시글 전체 조회는 나중에 작성된 게시글이 상단에 조회
		 * - 게시글 상세 조회는 게시글 번호를 입력하여 게시글 내용을 확인
		 * - 게시글 상세 조회를 하면 조회수가 1 증가
		 * - 게시글 수정은 게시글 번호를 선택하면 해당 게시글의 제목, 내용을 수정
		 * - 게시글 삭제는 게시글 번호를 선택하면 해당 게시글을 삭제
		 * */
		int menu = -1;
		ArrayList<Board> list = new ArrayList<Board>();
		
		do {
			printMenu();
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				//메뉴에서 입력한 엔터 처리
				scan.nextLine();
				
				//콘솔에서 입력받아 게시글 객체 생성
				Board insertTmp = inputBoard();
				
				//게시글을 목록에 추가
				insertBoard(list, insertTmp);
				break;
			case 2:
				//서브메뉴 출력
				printSubMenu(menu);
				//서브 메뉴 선택
				int subMenu = scan.nextInt();
				//서브 메뉴에 따른 기능 실행
				printBoard(list, subMenu);
				break;
			case 3:
				//게시글 번호 입력
				System.out.print("수정할 게시글 번호 입력 : ");
				int num2 = scan.nextInt();
				//번호와 일치하는 게시글을 가져옴
				int index = list.indexOf(new Board(num2));
				if(index == -1) {
					printStr("일치하는 게시글이 없습니다.");
					continue;
				}
				Board tmp = list.get(index);
				
				//일치하는 게시글이 있으면 제목, 내용을 입력
				scan.nextLine();
				System.out.print("제목 : ");
				String title = scan.nextLine();
				System.out.print("내용 : ");
				String content = scan.nextLine();
				
				//입력받은 제목, 내용으로 게시글을 수정
				tmp.update(title, content);
				break;
			case 4:
				//게시글 번호 입력
				System.out.print("삭제할 게시글 번호 입력 : ");
				int num = scan.nextInt();
				//게시글 번호에 맞는 게시글 삭제
				//게시글 번호를 이용하여 게시글 객체를생성하여 삭제
				if(list.remove(new Board(num))) {
					printStr("게시글이 삭제되었습니다.");
				}else {
					printStr("일치하는 게시글이 없습니다.");
				}
				break;
			case 5:
				printStr("프로그램 종료!!");
				break;
			default:
				printStr("잘못된 메뉴입니다.");
			}
		}while(menu != 5);
	}
	
	public static void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 조회");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("----------------");
		System.out.print("메뉴 선택 : ");
	}
	public static void printSubMenu(int menu) {
		switch(menu) {
		case 2:
			System.out.println("----조회 메뉴-----");
			System.out.println("1. 전체 조회");
			System.out.println("2. 상세 조회");
			System.out.println("----------------");
			System.out.print("메뉴 선택 : ");
			break;
		}
	}
	public static void printStr(String str) {
		System.out.println("------------------------");
		System.out.println(str);
		System.out.println("------------------------");
	}
	public static void insertBoard(ArrayList<Board> list, Board board) {
		//목록에 추가
		//0번지에 추가하는 이유는 나중에 등록된 게시글이 위로 가게 하기 위해서
		list.add(0, board);
		printStr("게시글이 등록됐습니다.");
	}
	public static Board inputBoard() {
		//게시글 정보를 입력(제목,내용, 작성자)
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.print("작성자: ");
		String writer = scan.next();
		//목록에 게시글 추가
		//게시글 객체 생성
		return new Board(title, content, writer);
	}
	public static void printAll(ArrayList<Board> list) {
		if(list == null || list.size() == 0) {
			printStr("등록된 게시글이 없습니다.");
			return;
		}
		//전체 조회
		for(Board tmp : list) {
			System.out.println(tmp);
		}
	}
	public static void printDetail(ArrayList<Board> list, int num) {
		//해당 번호와 맞는 게시글 조회
		int index = list.indexOf(new Board(num));
		
		if(index == -1) {
			printStr("없는 게시글 번호입니다.");
			return;
		}
		//게시글 조회수 증가
		list.get(index).updateViews();
		//게시글 출력
		System.out.println(list.get(index).print());
	}
	public static void printBoard(ArrayList<Board> list, int subMenu) {
		switch(subMenu) {
		case 1:
			printAll(list);
			break;
		case 2:
			//상세 조회
			//번호 입력
			System.out.print("게시글 번호 : ");
			int num = scan.nextInt();
			printDetail(list, num);
			break;
		default:
			printStr("잘못된 메뉴입니다.");
		}
	}
}
