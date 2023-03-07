package kr.kh.test.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
}
