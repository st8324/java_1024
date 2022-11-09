package day13;

public class Score {
	//필드 : 과목, 학기, 중간, 기말, 수행평가, 총점
	private String title;
	private int term, midScore, finalScore, performance;
	private double total;
	private double midRate = 0.4, finalRate = 0.5, performanceRate = 0.1;
	//메소드 : equals() : 성적 추가 시 활용, toString() 성적 출력 시 활용
	//       getter, setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public int getMidScore() {
		return midScore;
	}
	public void setMidScore(int midScore) {
		this.midScore = midScore;
	}
	public int getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	public int getPerformance() {
		return performance;
	}
	public void setPerformance(int performance) {
		this.performance = performance;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "[" + term +"학기 " +  title + " 중간 : " + midScore + ",기말 : " 
				+ finalScore + ", 수행 : " + performance + ", 총점 : " + total + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (term != other.term)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	//생성자 : 과목, 학기, 중간, 기말, 수행평가가 필요한 생성자
	public Score(String title, int term, int midScore, int finalScore, 
			int performance) {
		this.title = title;
		this.term = term;
		this.midScore = midScore;
		this.finalScore = finalScore;
		this.performance = performance;
		this.total = midRate*midScore + finalScore*finalRate + performance*performanceRate;
	}
	//      : 과목, 학기가 필요한 생성자(성적이 같은지 확인할 때)
	public Score(String title, int term) {
		this.title = title;
		this.term = term;
	}
	//복사 생성자
	public Score(Score s) {
		this(s.title, s.term, s.midScore, s.finalScore, s.performance);
	}
}
