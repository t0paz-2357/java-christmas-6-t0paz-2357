package christmas;

public enum DessertMenu {
	DESSERT_CHOCOLATECAKE("초코케이크", 15000), DESSERT_ICECREAM("아이스크림", 5000);

	private String category = "DESSERT";
	private String dessertName;
	private int dessertPrice;

	DessertMenu(String dessertName, int dessertPrice) {
		this.dessertName = dessertName;
		this.dessertPrice = dessertPrice;
	}

	public String getCategory() {
		return category;
	}

	public String getDessertName() {
		return dessertName;
	}

	public int getDessertPrice() {
		return dessertPrice;
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