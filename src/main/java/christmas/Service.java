package christmas;

import java.util.*;

public class Service {
	private InputView inputView;
	private OutputView outputView;

	private List<Order> orderedMenu = new ArrayList<Order>();
	private int date;

	public void start(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;

		run();
	}

	public void run() {
		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
		inputCalendar(); // 방문 날짜 입력
		inputOrder(); // 주문 입력
		printVisitingDate(); // 방문 날짜 출력
		printOrder(); // 주문 메뉴 출력
		printCalculatedBeforeTotalPrice(); // 총주문 금액 출력
		//considerCalendar(date, orderedMenu); // 달력 고려한 조건
	}

	public void inputCalendar() { // inputView
		date = inputView.readDate(); // 날짜 입력
	}

	public void inputOrder() { // inputView
		orderedMenu = inputView.readOrder(); // 주문 입력
	}

	public void printVisitingDate() { // OutputView
		outputView.printVisitingDate(date); // 방문 날짜 출력
	}

	public void printOrder() { // OutputView
		outputView.printOrderMenu(orderedMenu); // 주문 출력
	}

	public void printCalculatedBeforeTotalPrice() { // 할인전 총가격 계산
		int totalPrice = 0;

		for (Order order : orderedMenu) {
			totalPrice += order.getOrderMenuPrice();
		}

		outputView.printBeforeTotalPrice(totalPrice);
	}

	public void considerCalendar(int date, List<Order> orderedList) {
		
	}
}
