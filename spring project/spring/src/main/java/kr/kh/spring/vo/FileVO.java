package kr.kh.spring.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileVO {

	int fi_num;
	String fi_ori_name;
	String fi_name;
	int fi_bo_num;
	
	public FileVO(String fi_ori_name, String fi_name, int fi_bo_num) {
		this.fi_ori_name = fi_ori_name;
		this.fi_name = fi_name;
		this.fi_bo_num = fi_bo_num;
	}
}
