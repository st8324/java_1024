package day12;

public class Student {
	public int grade, classNum, num;
	public String name;
	
	@Override
	public boolean equals(Object obj) {
		//같은 객체 공유
		if (this == obj)
			return true;
		//null과 비교 불가능
		if (obj == null)
			return false;
		//obj가 같은 클래스의 객체가 아닌 경우
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (classNum != other.classNum)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classNum=" + classNum + ", num=" + num + ", name=" + name + "]";
	}
	
}
