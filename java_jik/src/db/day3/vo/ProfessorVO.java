package db.day3.vo;

import lombok.Data;

@Data
public class ProfessorVO {
	private String pr_num;
	private String pr_name;
	private String pr_state;
	private String pr_de_num;
	private String pr_tel;

	public ProfessorVO(String pr_num, String pr_name, String pr_state, String pr_de_num, String pr_tel) {
		this.pr_num = pr_num;
		this.pr_name = pr_name;
		this.pr_state = pr_state;
		this.pr_de_num = pr_de_num;
		this.pr_tel = pr_tel;
	}
	
}
