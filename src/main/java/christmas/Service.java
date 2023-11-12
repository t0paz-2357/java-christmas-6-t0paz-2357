package christmas;

import java.util.*;

public class Service {
	private InputView inputView;
	private OutputView outputView;
	private static final int OVER_5000 = 0;
	private static final int OVER_10000 = 1;
	private static final int OVER_20000 = 2;
	private static final int DISCOUNT_MENU_PRICE = 2023;
	private static final int DISCOUNT_SPECIAL_PRICE = 1000;

	private List<Order> orderedMenu = new ArrayList<Order>(); // 주문한 메뉴
	private int date; // 날짜
	private int totalPrice = 0; // 할인전 총금액
	private int totalDiscountPrice = 0; // 총혜택 금액 = 할인 금액 + 증정용 금액
	private int discountPrice = 0; // 할인 금액
	private int offerChampagne = 0; // 증정용 샴페인
	private String[] eventBadge = { "별", "트리", "산타" }; // 이벤트 배지
	private int christmasDDayDiscountPrice = 1000; // 크리스마스 디데이 할인
	private boolean isWeekday = false; // 평일 할인 여부 확인
	private boolean isWeekend = false; // 주말 할인 여부 확인
	private boolean isSpecial = false; // 특별 일자 할인 여부 확인
	private HashMap<String, Integer> eventDiscountList = new HashMap<String, Integer>(); // 받은 혜택 목록

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
		printCalculatedBeforeDiscountPrice(); // 총주문 금액 출력
		discountEvents();
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

	public void printCalculatedBeforeDiscountPrice() { // 할인전 총가격 계산
		for (Order order : orderedMenu) {
			totalPrice += order.getOrderMenuPrice();
		}

		outputView.printBeforeDiscountPrice(totalPrice);
	}

	public void discountEvents() {
		outputView.printOfferedChampagne(this.printOfferedChampagne()); // 증정 메뉴 출력
		outputView.printEvents(this.saveAppliedEvents()); // 혜택 내역
		outputView.printDiscountAmount(this.calculateDiscountCost()); // 총혜택 금액
		outputView.printAfterDiscountPrice(this.printCalculatedAfterDiscountPrice()); // 할인 후 예상 결제 금액
		outputView.printEventBadge(this.printEventBadge()); // 이벤트 배지
	}

	public String printOfferedChampagne() { // 증정 메뉴
		offerChampagne = totalPrice / 120000;

		if (offerChampagne > 0) {
			eventDiscountList.put("증정 이벤트", Menu.CHAMPAGNE.getMenuPrice() * offerChampagne);
			return "샴페인 " + offerChampagne + "개";
		}

		return "없음";
	}

	// -------------------혜택 금액 계산=-----------------------
	public int calculateDiscountCost() { // 총혜택 금액
		totalDiscountPrice = discountPrice + Menu.CHAMPAGNE.getMenuPrice() * offerChampagne;
		return totalDiscountPrice;
	}

	public int printCalculatedAfterDiscountPrice() { // 할인 후 예상 결제 금액
		return totalPrice - discountPrice;
	}

	public String printEventBadge() { // 총혜택금액으로 배지
		if (totalDiscountPrice >= 5000 && totalDiscountPrice < 10000)
			return eventBadge[OVER_5000];

		if (totalDiscountPrice >= 10000 && totalDiscountPrice < 20000)
			return eventBadge[OVER_10000];

		if (totalDiscountPrice >= 20000)
			return eventBadge[OVER_20000];

		return "없음";
	}

	// -------------------날짜 할인 계산=-----------------------
	public HashMap<String, Integer> saveAppliedEvents() {
		considerCalendar();
		return eventDiscountList;
	}

	public void considerCalendar() {
		isWeekday = Calendar.isWeekday(date);
		isWeekend = Calendar.isWeekend(date);
		isSpecial = Calendar.isSpecial(date);

		if (isWeekend)
			calculateWeekendDiscountCost();

		if (isWeekday)
			calculateWeekdayDiscountCost();

		if (isSpecial)
			calculateSpecialDiscountCost();

		if (date < 26)
			calculateChristmasDDayDiscount();
	}

	public void calculateChristmasDDayDiscount() {
		christmasDDayDiscountPrice += (date - 1) * 100;

		discountPrice += christmasDDayDiscountPrice;
		eventDiscountList.put("크리스마스 디데이 할인", christmasDDayDiscountPrice);
	}

	public void calculateWeekendDiscountCost() {
		int discountMainPrice = 0;
		Menu menu;

		for (Order order : orderedMenu) {
			menu = Menu.getOneMenu(order.getOrderMenuName());
			if (menu.getMenuCategory().equals("메인")) {
				discountMainPrice += DISCOUNT_MENU_PRICE * order.getOrderMenuCount();
			}
		}

		discountPrice += discountMainPrice;
		if (discountMainPrice != 0)
			eventDiscountList.put("주말 할인", discountMainPrice);
	}

	public void calculateWeekdayDiscountCost() {
		int discountDessertPrice = 0;
		Menu menu;

		for (Order order : orderedMenu) {
			menu = Menu.getOneMenu(order.getOrderMenuName());
			if (menu.getMenuCategory().equals("디저트")) {
				discountDessertPrice += DISCOUNT_MENU_PRICE * order.getOrderMenuCount();
			}
		}

		discountPrice += discountDessertPrice;
		if (discountDessertPrice != 0)
			eventDiscountList.put("평일 할인", discountDessertPrice);
	}

	public void calculateSpecialDiscountCost() {
		if (Calendar.isSpecial(date)) {
			discountPrice += DISCOUNT_SPECIAL_PRICE;
		}

		eventDiscountList.put("특별 할인", DISCOUNT_SPECIAL_PRICE);
	}
}
