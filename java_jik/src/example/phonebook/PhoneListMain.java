package example.phonebook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class PhoneListMain {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 전화번호를 관리하는 프로그램을 작성하세요.
		 * 1. 전화번호 추가(성, 이름, 직장, 전화번호들(이름 : 번호))
		 * 2. 전화번호 수정
		 *    - 이름으로 검색(성+이름)
		 *    - 검색된 사람들 중에서 선택
		 *    - 성, 이름을 수정할건지, 
		 *      기존 등록된 전화번호를 수정할건지,
		 *      새 전화번호를 등록한건지를 선택하여 동작
		 * 3. 전화번호 삭제
		 *    - 이름으로 검색(성+이름)
		 *    - 검색된 사람들 중에서 선택
		 *    - 선택된 사람의 연락처를 삭제
		 * 4. 전화번호 조회
		 *    - 이름으로 검색
		 *    - 검색된 사람들 중에서 선택
		 *    - 선택된 사람의 연락처를 출력
		 * */
		//반복
		int menu = -1;
		ArrayList<PhoneBook> list = new ArrayList<PhoneBook>();
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				System.out.println("=====================");
				//선택한 메뉴에 대한 기능 실행
				runMenu(menu, list);
			}catch(RuntimeException e) {
				System.out.println(e.getMessage());
				System.out.println("=====================");
			}
		}while(menu != 5);
	}

	private static void runMenu(int menu, ArrayList<PhoneBook> list) {
		switch(menu) {
		//1.번호 추가
		case 1:
			if(insertPhoneBook(list)) {
				System.out.println("전화번호를 추가했습니다.");
				System.out.println("=====================");
			}else {
				System.out.println("전화번호를 추가하지 못했습니다.");
				System.out.println("=====================");
			}
			break;
		//2. 번호 수정
		case 2:
			if(updatePhoneBook(list)) {
				System.out.println("전화번호를 수정했습니다.");
				System.out.println("=====================");
			}else {
				System.out.println("전화번호를 수정하지 못했습니다.");
				System.out.println("=====================");
			}
			
			break;
		//3. 번호 삭제
		case 3:
			if(deletePhoneBook(list)) {
				System.out.println("전화번호를 삭제했습니다.");
				System.out.println("=====================");
			}else {
				System.out.println("전화번호를 삭제하지 못했습니다.");
				System.out.println("=====================");
			}
				
			
			break;
		//4. 번호 조회
		case 4:
			printSearchNumber(list);
			
			break;
		//5. 프로그램 종료
		case 5:
			System.out.println("프로그램 종료");
			System.out.println("=====================");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 다시 선택하세요.");
			System.out.println("=====================");
		}
	}
	
	private static boolean updatePhoneBook(ArrayList<PhoneBook> list) {
		//이름을 입력
		scan.nextLine();//엔터 처리
		//이름을 입력
		System.out.print("이름 : ");
		String name = scan.nextLine();
		//이름이 포함된 전화번호부를 검색하여 출력(번호와 함께)
		ArrayList<Integer> indexs 
		= searchPhoneBook(list,p->p.getName().contains(name));
	
		printIndexsNumber(list, indexs);
	
		System.out.println("번호 선택 : ");
		//수정할 전화번호부를 선택
		int selectIndex = scan.nextInt() - 1;
		
		if(selectIndex < 0 || selectIndex >= indexs.size())
			throw new RuntimeException("잘못 선택했습니다.");

		//서브 메뉴 출력
		printSubMenu();
		
		//서브 메뉴 선택
		int subMenu = scan.nextInt();
		
		//서브 메뉴 실행
		int index = indexs.get(selectIndex);
		return runSubMenu(subMenu, list.get(index));
	}

	private static boolean runSubMenu(int subMenu, PhoneBook pb) {
		if(pb == null){
			return false;
		}
		switch(subMenu) {
		//1. 이름, 직장 수정
		case 1:
			//이름 직장 입력
			scan.nextLine();//공백 처리(메뉴 입력 후 남은 엔터)
			System.out.print("성명 : ");
			String name = scan.nextLine();
			System.out.print("직장 : ");
			String company = scan.nextLine();
			
			//이름, 직장을 수정
			pb.update(name, company);
			break;
		//2. 기존 전화번호 수정
		case 2:
			//기존 전화번호들를 출력
			pb.printPhoneNumbers();
			//수정할 전화번호를 선택
			System.out.print("번호 입력 : ");
			int index = scan.nextInt() - 1;
			//이름, 번호를 입력
			scan.nextLine();
			System.out.print("이름 : ");
			String pName = scan.nextLine();
			System.out.print("번호 : ");
			String number = scan.nextLine();
			//선택한 전화번호 이름, 번호를 수정
			pb.getPnList().get(index).update(pName,number);
			break;
		//3. 새 전화번호 추가
		case 3:
			//이름 번호를 입력
			scan.nextLine();
			ArrayList<PhoneNumber> pnList = inputPhoneNumbers();
			//새 전화번호를 추가
			pb.getPnList().addAll(pnList);
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
			System.out.println("=====================");
			return false;
		}
		return true;
	}

	private static void printSubMenu() {
		System.out.println("=======수정 메뉴=======");
		System.out.println("1. 이름, 직장 수정");
		System.out.println("2. 기존 전화번호 수정"); 
		System.out.println("3. 새 전화번호 등록");
		System.out.println("=====================");
		System.out.print("메뉴 선택 : ");
	}

	private static void printIndexsNumber(ArrayList<PhoneBook> list,
			ArrayList<Integer> indexs) {
		if(indexs == null || indexs.size() == 0 || 
			list == null || list.size() == 0) {
			throw new RuntimeException("검색 결과가 없습니다.");
		}
		
		for(int i = 0 ; i<indexs.size(); i++) {
			int index = indexs.get(i);
			System.out.println(i+1 +". " + list.get(index));
		}
		System.out.println("=====================");
	}
	private static void printSearchNumber(ArrayList<PhoneBook> list) {
		scan.nextLine();//엔터 처리
		//이름을 입력
		System.out.print("이름 : ");
		String name = scan.nextLine();
		//이름이 포함된 전화번호부를 검색하여 번지를 확인
		ArrayList<Integer> indexs 
			= searchPhoneBook(list,p->p.getName().contains(name));
		
		printIndexsNumber(list, indexs);
		
		System.out.println("번호 선택 : ");
		//조회할 전화번호부를 선택
		int selectIndex = scan.nextInt() - 1;
		if(selectIndex < 0 || selectIndex >= indexs.size())
			return ;
		
		list.get(selectIndex).print();
	}

	private static boolean deletePhoneBook(ArrayList<PhoneBook> list) {
		scan.nextLine();//엔터 처리
		//이름을 입력
		System.out.print("이름 : ");
		String name = scan.nextLine();
		//이름이 포함된 전화번호부를 검색하여 번지를 확인
		ArrayList<Integer> indexs 
			= searchPhoneBook(list,p->p.getName().contains(name));
		
		//확인된 번지에 있는 번호들을 출력(번호와 함께)
		printIndexsNumber(list, indexs);
		
		System.out.println("번호 선택 : ");
		//삭제할 전화번호부를 선택
		int selectIndex = scan.nextInt() - 1;
		if(selectIndex < 0 || selectIndex >= indexs.size())
			return false;
		//전화번호를 삭제
		int deleteIndex = indexs.get(selectIndex);
		return list.remove(deleteIndex) != null;
	}

	private static ArrayList<Integer> searchPhoneBook(ArrayList<PhoneBook> list, 
			Predicate<PhoneBook> p) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		
		for(int i = 0 ;i < list.size(); i++) {
			if(p.test(list.get(i)))
				indexs.add(i);
		}
		return indexs;
	}

	private static ArrayList<PhoneNumber> inputPhoneNumbers(){
		ArrayList<PhoneNumber> pnList = new ArrayList<PhoneNumber>();
		do {
			//입력받은 이름, 번호를 이용하여 PhoneNumber 객체를 만들고,
			PhoneNumber pn = inputPhoneNumber(); 
			//만들어진 PhoneNumber 객체를 PhoneNumber 리스트에 추가
			pnList.add(pn);
			//전화번호를 더 입력할건지 물어봄
			System.out.print("더 입력하겠습니까?(y/n) : ");
		}while(scan.nextLine().charAt(0) != 'n');
		return pnList;
	}
	
	private static PhoneNumber inputPhoneNumber() {
		//전화번호를 입력(이름 : 번호) => PhoneNumber
		System.out.print("이름(집, 직장 등) : ");
		String pName = scan.nextLine();
		System.out.print("번호(예:010-1234-4567) : ");
		String number = scan.nextLine();
		return new PhoneNumber(pName, number);
	}
	
	private static boolean insertPhoneBook(ArrayList<PhoneBook> list) {
		//성명, 직장 입력
		scan.nextLine();//공백 처리(메뉴 입력 후 남은 엔터)
		System.out.print("성명 : ");
		String name = scan.nextLine();
		System.out.print("직장 : ");
		String company = scan.nextLine();
		
		ArrayList<PhoneNumber> pnList;
		try {
			//전화번호들을 입력
			pnList = inputPhoneNumbers();
		}
		catch (RuntimeException e) {
			return false;
		}
		System.out.println("=====================");
		//성명, 직장, 전화번호들(PhoneNumber 리스트)을 이용하여 PhoneBook객체를 생성
		PhoneBook pb = new PhoneBook(name, company, pnList);
		
		//list에 PhoneBook 객체를 추가
		list.add(pb);
		return true;
	}

	private static void printMenu() {
		System.out.println("=========메뉴=========");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("=====================");
		System.out.print("메뉴 선택 : ");
	}

}
