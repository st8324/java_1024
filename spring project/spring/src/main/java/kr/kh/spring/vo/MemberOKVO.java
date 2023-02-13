package kr.kh.spring.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberOKVO {
	String mo_me_id;
	String mo_num;
	Date mo_valid_time;
	public MemberOKVO(String mo_me_id, String mo_num) {
		this.mo_me_id = mo_me_id;
		this.mo_num = mo_num;
		this.mo_valid_time = new Date();
	}
}
