package kr.kh.test.pagination;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum;
	private Criteria cri;
	
	/* endPage, startPage, prev, next 값 계산 */
	public void calcData() {
		/* starPage와 endPage는 현재 페이지 정보인 criteria와 displayPageNum을 이용하여 계산
		 * displayPageNum이 10이고 현재 페이지가 3페이지면 startPage = 1, endPage = 10이 되도록 계산 */
		endPage = (int) (Math.ceil(cri.getPage()/(double) displayPageNum)*displayPageNum);
		
		startPage = (endPage - displayPageNum)+1;
		/* 총 콘텐츠 갯수를 이용하여 마지막 페이지 번호를 계산 */
		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		/* 현재 페이지에 계산된 현재 페이지메이커의 마지막 페이지 번호와 실제 마지막 페이지 번호를 비교하여
		 * 작은 값이 마지막 페이지 번호가 됨 */
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		/* 현재 페이지메이커에 시작페이지가 1페이지면 prev가 없어야 함 */
		prev = startPage == 1 ? false : true;
		/* 현재 페이지메이커에 마지막 페이지에 컨텐츠의 마지막이 포함되어 있으면 next가 없어야 함 */
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true;
	}

	public PageMaker(int totalCount, int displayPageNum, Criteria cri) {
		this.totalCount = totalCount;
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		calcData();
	}
}