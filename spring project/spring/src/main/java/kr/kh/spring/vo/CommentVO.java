package kr.kh.spring.vo;

import java.text.SimpleDateFormat;
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
	
	public String getCo_register_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(co_register_date == null)
			return "";
		return format.format(co_register_date);
	}
	public String getCo_update_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(co_update_date == null)
			return "";
		return format.format(co_update_date);
	}
	
	public CommentVO(String co_content, String co_me_id, int co_bo_num, 
			int co_ori_num) {
		this.co_content = co_content;
		this.co_me_id = co_me_id;
		this.co_bo_num = co_bo_num;
		this.co_ori_num = co_ori_num;
	}
}
