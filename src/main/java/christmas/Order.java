package christmas;

import java.util.*;

public class Order {
	private String orderMenuName;
	private int orderMenuCount;
	private int orderMenuPrice;

	List<Menu> menuList = new ArrayList<Menu>();
	List<Order> orderList = new ArrayList<Order>();

	public Order(String orderMenuName, int orderMenuCount) {
		Menu menu = Menu.getOneMenu(orderMenuName);

		this.orderMenuName = orderMenuName;
		this.orderMenuCount = orderMenuCount;
		this.orderMenuPrice = menu.getMenuPrice() * orderMenuCount;
	}

	public String getOrderMenuName() {
		return orderMenuName;
	}

	public void setOrderMenuName(String orderMenuName) {
		this.orderMenuName = orderMenuName;
	}

	public int getOrderMenuCount() {
		return orderMenuCount;
	}

	public void setOrderMenuCount(int orderMenuCount) {
		this.orderMenuCount = orderMenuCount;
	}

	public int getOrderMenuPrice() {
		return orderMenuPrice;
	}

	public void setOrderMenuPrice(int orderMenuPrice) {
		this.orderMenuPrice = orderMenuPrice;
	}
}
