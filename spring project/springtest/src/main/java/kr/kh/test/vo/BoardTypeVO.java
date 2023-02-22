package kr.kh.test.vo;

import lombok.Data;

@Data
public class BoardTypeVO {
	int bt_num;
	String bt_type;
	String bt_name;
	int bt_r_authority;
	int bt_w_authority;
}
