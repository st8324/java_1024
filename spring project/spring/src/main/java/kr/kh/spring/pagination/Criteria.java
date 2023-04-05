package kr.kh.spring.pagination;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Criteria {

	//현재 페이지
	private int page; 
	//한 페이지 당 컨텐츠 갯수
	private int perPageNum;
	//검색어
	private String search;
	//게시판 번호
	private int type;
	
	private ArrayList<String> test = new ArrayList<String>(); 
	
	//Criteria 디폴트 생성자 : 현재 페이지를 1페이지로, 한 페이지에 10개의 컨텐츠
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
		this.search = "";
		this.type = 0;
	}
	/* 쿼리문에서 limit에 사용되는 인덱스를 계산하는 getter */
	public int getPageStart() {
		return (this.page -1) * perPageNum;
	}
}
