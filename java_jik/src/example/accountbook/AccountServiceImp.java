package example.accountbook;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AccountServiceImp implements AccountService{

	@Override
	public void insertItem(ArrayList<Item> list, Item item) {
		//리스트에 내역 추가
		list.add(item);
		//날짜를 기준으로 정렬
		Collections.sort(list,new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				if(o1 == null)
					return 1;
				if(o2 == null)
					return -1;
				//if(!o1.getDate().equals(o2.getDate()))
				return o1.getDate().compareTo(o2.getDate());
			}
		});
	}

	@Override
	public void printItem(ArrayList<Item> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateItem(ArrayList<Item> list, int index, Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(ArrayList<Item> list, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void printMenu() {
		System.out.println("=========메뉴=========");
		System.out.println("1. 내역 추가");
		System.out.println("2. 내역 확인");
		System.out.println("3. 내역 수정");
		System.out.println("4. 내역 삭제");
		System.out.println("5. 종료");
		System.out.println("=====================");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(ArrayList<Item> list, int menu, Scanner scan) throws ParseException {
		
		switch(menu) {
		case 1:
			//내역 정보를 입력
			//가계부에 내역을 추가
			insertItem(list, inputItem(scan));
			break;
		case 2:
			System.out.println("확인 기능");
			for(Item tmp : list) {
				tmp.print();
			}
			break;
		case 3:
			//년 월 일을 입력(2022-11-16)
			System.out.print("일시 입력 : ");
			String date = scan.next();
			
			//해당 일자에 기록된 내역들을 출력
			//날짜가 같은 내역들의 번지를 정수형 리스트에 저장
			ArrayList<Integer> indexList = 
				new ArrayList<Integer>();
			//날짜가 같은 내역들을 모음
			for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getDateStr().equals(date))
					indexList.add(i);
			}
			//날짜가 같은 내역들을 출력
			for(int i = 0; i<indexList.size(); i++) {
				System.out.println(i+1+"번 내역");
				list.get(indexList.get(i)).print();
			}
			//수정할 내역을 선택
			System.out.print("내역 선택 : ");
			int index = scan.nextInt() - 1;
			
			//수정할 내역 전체를 입력함
			Item item = inputItem(scan);
			
			//입력된 내용으로 수정
			list.set(indexList.get(index), item);
			
			break;
		case 4:
			//년 월 일을 입력(2022-11-16)
			
			//해당 일자에 기록된 내역들을 출력
			
			//삭제할 내역을 선택
			
			//내역을 삭제
			System.out.println("삭제 기능");
			break;
		case 5:
			break;
		default:
			System.out.println("없는 메뉴입니다.");
		}
		
	}

	@Override
	public Item inputItem(Scanner scan) throws ParseException {
		//구분, 목적, 내용, 금액, 일시를 입력
		System.out.print("구분(수입/지출) : ");
		String type = scan.next();
		System.out.print("분류(식비/교통비 등) : ");
		String purpose = scan.next();
		scan.nextLine();//위에서 입력한 엔터 처리
		System.out.print("내용 : ");
		String content = scan.nextLine();
		System.out.print("금액(정수) : ");
		int money = scan.nextInt();
		System.out.print("일시(2022-11-16) : ");
		String date = scan.next();
		return new Item(type, purpose, content, money, date);
	}

}
