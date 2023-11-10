package christmas;

public enum DrinkMenu {
	DRINK_ZEROCOKE("제로콜라", 3000), DRINK_REDWINE("레드와인", 60000), DRINK_CHAMPAGNE("샴페인", 25000);

	private String category = "Drink";
	private String drinkName;
	private int drinkPrice;

	DrinkMenu(String drinkName, int drinkPrice) {
		this.drinkName = drinkName;
		this.drinkPrice = drinkPrice;
	}

	public String getCategory() {
		return category;
	}

	public String getDrinkName() {
		return drinkName;
	}

	public int getDrinkPrice() {
		return drinkPrice;
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