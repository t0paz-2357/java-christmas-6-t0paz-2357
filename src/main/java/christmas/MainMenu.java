package christmas;

public enum MainMenu {
	STEAK("티본스테이크", 55000), RIB("바비큐립", 54000), SEAPASTA("해산물파스타", 35000), XMASPASTA("크리스마스파스타", 25000),
	MUSHROOMSOUP("양송이수프", 6000), TAPAS("타파스", 5500), CAESARSALAD("시저샐러드", 8000),
	ZEROCOKE("제로콜라", 3000), REDWINE("레드와인", 60000), CHAMPAGNE("샴페인", 25000),
	CHOCOLATECAKE("초코케이크", 15000), ICECREAM("아이스크림", 5000);

	private String mainName;
	private int mainPrice;

	MainMenu(String mainName, int mainPrice) {
		this.mainName = mainName;
		this.mainPrice = mainPrice;
	}

	public String getMainName() {
		return mainName;
	}

	public int getMainPrice() {
		return mainPrice;
	}
}

/*
 * <애피타이저> 양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
 * 
 * <메인> 티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
 * 
 * <디저트> 초코케이크(15,000), 아이스크림(5,000)
 * 
 * <음료> 제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
 */