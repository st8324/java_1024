package kr.kh.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	int bo_num;
	String bo_title;
	String bo_content;
	Date bo_register_date;
	Date bo_update_date;
	int bo_views;
	int bo_up;
	int bo_down;
	int bo_ori_num;
	String bo_me_id;
	int bo_bt_num;
	String bt_type;
	String bt_name;
	
	public String getBo_register_date_str() {
		SimpleDateFormat format = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(bo_register_date);
	}
}
