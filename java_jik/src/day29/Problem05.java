package day29;

public class Problem05 {

	public static void main(String[] args) {
		/* 1부터 10까지 출력하는 코드를 작성하려고 합니다. 아래 코드를 실행했을 때 결과와 이유를 작성하고,
		 * 올바르게 수정한 코드를 작성하세요.
		 * 결과
		 * 11
		 * 원인 : ;을 for() 끝에 추가해서 반복문의 실행문이 없이 동작. 반복문이 다 종료 된 후,
		 *       i를 출력하기 때문에 한 번만 출력
		 * */
		int i;
		for(i = 1; i<=10; i++);
			System.out.println(i);
		/*
		while(true) {
			if(i == 10);
				break;
			i++;
		}
		*/
	}

}
