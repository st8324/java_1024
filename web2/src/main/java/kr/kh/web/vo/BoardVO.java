package kr.kh.web.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	int board_num;
	String board_title;
	String board_writer;
	String board_content;
	Date board_date;
	
	public BoardVO(String board_title, String board_writer, String board_content) {
		this.board_title = board_title;
		this.board_writer = board_writer;
		this.board_content = board_content;
	}
}
