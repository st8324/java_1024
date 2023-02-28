package kr.kh.spring.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LikesVO {
	int li_num;
	int li_state;
	String li_me_id;
	int li_bo_num;
	
	public LikesVO(int li_state, String li_me_id, int li_bo_num) {
		this.li_state = li_state;
		this.li_me_id = li_me_id;
		this.li_bo_num = li_bo_num;
	}
}
