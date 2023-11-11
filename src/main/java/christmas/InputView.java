package christmas;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final int ORDER_MENU_NAME = 0;
	private static final int ORDER_MENU_COUNT = 1;

	public int readDate() { // 방문 날짜 입력
		System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!");
		int date = Integer.parseInt(Console.readLine());
		if (date > 31 || date < 1)
			throw new IllegalArgumentException();
		return date;
	}

	public List<Order> readOrder() { // 메뉴와 개수 입력
		System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
		String[] inputOrder = Console.readLine().split(",");

		List<Order> order = new ArrayList<Order>();

		for (String input : inputOrder) {
			String[] temp = input.split("-");
			order.add(new Order(temp[ORDER_MENU_NAME], Integer.parseInt(temp[ORDER_MENU_COUNT])));
		}

		return order;
	}
}
