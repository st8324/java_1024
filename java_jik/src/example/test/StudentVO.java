package example.test;


import lombok.Data;

@Data
class StudentVO{
	String st_num;
	String st_name;
	int st_semester;
	String st_state;
	String st_pr_num;
	
	public StudentVO(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
	}

	@Override
	public String toString() {
		return "[학번 : " + st_num + ", 이름 : " + st_name + ", 학기 : " + st_semester 
				+ ", 재학상태 : "	+ st_state + ", 지도교수 번호 :" + st_pr_num + "]";
	}
}
