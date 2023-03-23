package kr.kh.spring.vo;

import java.util.ArrayList;

import lombok.Data;

@Data
public class BoardListDTO {
	ArrayList<BoardVO> list = new ArrayList<BoardVO>();
}
