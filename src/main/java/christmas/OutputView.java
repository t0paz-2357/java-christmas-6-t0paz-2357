package christmas;

public class OutputView {
	public void printVisitingDate(int date) {
		System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
	}

	public void printOrderMenu() {
		System.out.println();
		System.out.println("<주문 메뉴>");
	}

	public void printBeforeTotalPrice() {
		System.out.println();
		System.out.println("<할인 전 총주문 금액>");
	}

	public void printFreeGiftMenu() {
		System.out.println();
		System.out.println("<증정 메뉴>");
	}

	public void printBenefits() {
		System.out.println();
		System.out.println("<혜택 내역>");
	}

	public void printDiscountAmount() {
		System.out.println();
		System.out.println("<총혜택 금액>");
	}

	public void printAfterTotalPrice() {
		System.out.println();
		System.out.println("<할인 후 예상 결제 금액");
	}

	public void printEventBadge() {
		System.out.println();
		System.out.println("<12월 이벤트 배지>");
	}
}