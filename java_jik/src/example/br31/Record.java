package example.br31;

class Record{
	private boolean [] userWinList;
	private int user;
	private int com;
	private int nowCount;
	public Record(int maxSize) {
		maxSize = maxSize >= 1?maxSize : 5;
		userWinList = new boolean[maxSize];
	}
	public int getUser() {
		return user;
	}
	public int getCom() {
		return com;
	}
	public void addRecord(boolean userWin) {
		userWinList[nowCount++] = userWin;
		com = userWin?com : com+1;
		user = userWin?user+1 : user;
	}
	public void printResult() {
		System.out.println("컴퓨터 : " + com + "승");
		System.out.println("사용자 : " + user + "승");
	}
}

