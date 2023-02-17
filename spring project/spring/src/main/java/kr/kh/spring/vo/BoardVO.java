package kr.kh.spring.vo;

import java.util.Date;

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
}
