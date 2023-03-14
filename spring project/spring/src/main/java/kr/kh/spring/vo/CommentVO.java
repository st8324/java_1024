package kr.kh.spring.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVO {
	int co_num;
	String co_content;
	Date co_register_date;
	Date co_update_date;
	String co_me_id;
	int co_bo_num;
	int co_ori_num;
	
	public CommentVO(String co_content, String co_me_id, int co_bo_num, 
			int co_ori_num) {
		this.co_content = co_content;
		this.co_me_id = co_me_id;
		this.co_bo_num = co_bo_num;
		this.co_ori_num = co_ori_num;
	}
}
