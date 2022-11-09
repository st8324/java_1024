package day13;

import lombok.Data;

@Data
public class Student2 {
	//필드 : 학년, 반, 번호, 이름, 성적들
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private Score []scoreList;
	private int maxSize; //최대 저장 가능한 성적 수
	private int count; //현재 저장된 성적 수 
	
	/**
	 * 학생 정보에 성적을 추가하는 메소드
	 * @param 추가할 성적
	 * @return 추가 여부
	 */
	public boolean addScore(Score score) {
		if(score == null) {
			return false;
		}
		//배열에 성적들이 꽉 찾을 때
		if(count == maxSize) {
			return false;
		}
		//학생의 성적 정보들 중에서 과목, 학기가 같은 성적 정보가 없으면 추가
		for(int i = 0; i < count; i++) {
			if(score.equals(scoreList[i])) {
				return false;
			}
		}
		scoreList[count] = new Score(score);
		count ++;
		return true;
	}
	//메소드 : getter/setter, equals():같은 객체인지 비교하기 위해
	//        toString() : 객체를 쉽게 문자열로 만들기 위해 
	
	@Override
	public String toString() {
		return "["+grade + "학년 " + classNum + "반 " + num + "번 " + name +"]";
	}
	
	
	//생성자 : 초기화
	//학년, 반, 번호, 이름이 필요한 생성자(학생정보 추가시 활용)
	public Student2(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		maxSize=30;
		scoreList = new Score[maxSize];
	}
	//학년, 반, 번호가 필요한 생성자(성적 추가 시 학생이 있는지 없는지 판별할 때 활용)
	public Student2(int grade, int classNum, int num) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		maxSize=30;
		scoreList = new Score[maxSize];
	}
	public void printScore() {
		for(int i = 0; i<count; i++) {
			System.out.println(scoreList[i]);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student2 other = (Student2) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classNum;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
	}
}
