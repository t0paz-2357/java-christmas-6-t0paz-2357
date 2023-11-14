package christmas;

import java.text.*;
import java.util.*;

public class OutputView {
	DecimalFormat formatter = new DecimalFormat("###,###");

	public void printVisitingDate(int date) {
		System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
	}

	public void printOrderMenu(List<Order> orderedMenu) { // 주문 출력
		System.out.println();
		System.out.println("<주문 메뉴>");

		for (Order order : orderedMenu)
			System.out.println(order.getOrderMenuName() + " " + order.getOrderMenuCount() + "개");
	}

	public void printBeforeDiscountPrice(int totalPrice) {
		System.out.println();
		System.out.println("<할인 전 총주문 금액>");
		System.out.println(formatter.format(totalPrice) + "원");
	}

	public void printOfferedChampagne(String offeredChampagne) {
		System.out.println();
		System.out.println("<증정 메뉴>");
		System.out.println(offeredChampagne);
	}

	public void printEvents(HashMap<String, Integer> eventList) {
		System.out.println();
		System.out.println("<혜택 내역>");

		if (!eventList.isEmpty()) {
			eventList.forEach((key, value) -> {
				System.out.println(key + ": -" + formatter.format(value) + "원");
			});
			return;
		}
		
		System.out.println("없음");
	}

	public void printDiscountAmount(int totalDiscountPrice) {
		System.out.println();
		System.out.println("<총혜택 금액>");
		
		if (totalDiscountPrice > 0) {
			System.out.println("-" + formatter.format(totalDiscountPrice) + "원");
			return;
		}
		
		System.out.println("0원");
	}

	public void printAfterDiscountPrice(int finalCost) {
		System.out.println();
		System.out.println("<할인 후 예상 결제 금액>");
		System.out.println(formatter.format(finalCost) + "원");
	}

	public void printEventBadge(String eventBadge) {
		System.out.println();
		System.out.println("<12월 이벤트 배지>");
		System.out.println(eventBadge);
	}
}
