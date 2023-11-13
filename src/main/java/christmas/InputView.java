package christmas;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final int ORDER_MENU_NAME = 0;
	private static final int ORDER_MENU_COUNT = 1;
	private static final int EXCEPTION_OCCURED = -1;
	private static final int LIMITED_COUNT = 20;
	private static int totalMenuCount = 0;

	public int readDate() { // 방문 날짜 입력
		System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
		while (true) {
			String date = Console.readLine();

			if (checkValidDateInput(date))
				continue;

			return Integer.parseInt(date);
		}
	}

	public List<Order> readOrder() { // 메뉴와 개수 입력
		System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
		while (true) {
			try {
				String[] inputOrder = Console.readLine().split(",");
				List<Order> order = new ArrayList<Order>();
				totalMenuCount = repeatAlgorithm(inputOrder, totalMenuCount, order);
				if (totalMenuCount > LIMITED_COUNT || totalMenuCount == EXCEPTION_OCCURED)
					throw new IllegalArgumentException();
				return order;
			} catch (IllegalArgumentException e) {
				continue;
			}
		}
	}

	public int repeatAlgorithm(String[] inputOrder, int totalMenuCount, List<Order> order) {
		totalMenuCount = 0;
		for (String input : inputOrder) {
			String[] temp = input.split("-");
			if (checkValidMenuName(temp[ORDER_MENU_NAME]))
				return EXCEPTION_OCCURED;
			if (checkValidMenuCount(temp[ORDER_MENU_COUNT]))
				return EXCEPTION_OCCURED;
			totalMenuCount += Integer.parseInt(temp[ORDER_MENU_COUNT]);
			order.add(new Order(temp[ORDER_MENU_NAME], Integer.parseInt(temp[ORDER_MENU_COUNT])));
		}
		return totalMenuCount;
	}

	public boolean checkValidDateInput(String date) {
		int temp = 0;

		try {
			temp = Integer.parseInt(date);

			if (temp > 31 || temp < 1)
				throw new IllegalArgumentException();

			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(Exception.DATE_INPUT_ERROR.getMessage());
			return true;
		}
	}

	public boolean checkValidMenuName(String inputMenuName) { // 유효한 메뉴 이름
		if (Menu.getOneMenu(inputMenuName) == null) {
			System.out.println(Exception.INVALID_MENU_INPUT_ERROR.getMessage());
			return true;
		}

		return false;
	}

	public boolean checkValidMenuCount(String inputMenuCount) { // 유효한 메뉴 개수
		int temp = 0;

		try {
			temp = Integer.parseInt(inputMenuCount);

			if (temp > 20 || temp < 1)
				throw new IllegalArgumentException();

			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(Exception.INVALID_MENU_INPUT_ERROR.getMessage());
			return true;
		}
	}
}
