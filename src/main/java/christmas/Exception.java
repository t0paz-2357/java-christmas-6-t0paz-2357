package christmas;

public enum Exception {
	DATE_INPUT_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
	INVALID_MENU_INPUT_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
	ONLY_DRINK_NOT_ALLOWED_ERROR("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.");
	
	private String message;
	
	Exception(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
