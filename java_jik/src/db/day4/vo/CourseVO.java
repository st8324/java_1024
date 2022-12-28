package db.day4.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseVO {
	private int co_num;
	private String co_st_num;
	private int co_le_num;
	private String co_type;
	private String co_grade;

	public CourseVO(String co_st_num, int co_le_num, String co_type) {
		this.co_st_num = co_st_num;
		this.co_le_num = co_le_num;
		this.co_type = co_type;
	}
}
