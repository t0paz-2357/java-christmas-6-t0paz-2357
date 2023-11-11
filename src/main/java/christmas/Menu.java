package christmas;

import java.util.*;

public enum Menu {
	STEAK("티본스테이크", 55000), RIB("바비큐립", 54000), SEAPASTA("해산물파스타", 35000), XMASPASTA("크리스마스파스타", 25000),
	MUSHROOMSOUP("양송이수프", 6000), TAPAS("타파스", 5500), CAESARSALAD("시저샐러드", 8000), ZEROCOKE("제로콜라", 3000),
	REDWINE("레드와인", 60000), CHAMPAGNE("샴페인", 25000), CHOCOLATECAKE("초코케이크", 15000), ICECREAM("아이스크림", 5000);

	private String menuName;
	private int menuPrice;

	Menu(String menuName, int menuPrice) {
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public static List<Menu> getAllMenu() {
		List<Menu> menuList = new ArrayList<Menu>();

		for (Menu menu : Menu.values())
			menuList.add(menu);

		return menuList;
	}

	public static Menu getOneMenu(String inputMenuName) {
		for (Menu menu : Menu.values()) {
			if (menu.getMenuName().equals(inputMenuName))
				return menu;
		}

		return null;
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