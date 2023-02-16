package kr.kh.spring.vo;

import lombok.Data;

@Data
public class BoardTypeVO {
	int bt_num;
	String bt_type;
	String bt_name;
	int bt_r_authority;
	int bt_w_authority;
	
	public String getBt_r_authority_str() {
		return getAuthority(bt_r_authority);
	}
	public String getBt_w_authority_str() {
		return getAuthority(bt_w_authority);
	}
	private String getAuthority(int authority) {
		switch(authority) {
		case 0:	return "비회원";
		case 1:	return "회원";
		case 9: return "관리자";
		case 10:return "최고 관리자";
		}
		return "";
	}
}
