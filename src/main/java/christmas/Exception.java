package christmas;

public enum Exception {
	DATE_INPUT_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
	INVALID_MENU_INPUT_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
	ONLY_DRINK_NOT_ALLOWED_ERROR("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요."),
	ONLY_TWENTY_MENU_ALLOWED_ERROR("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");
	
	private String message;
	
	Exception(String meesage) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
