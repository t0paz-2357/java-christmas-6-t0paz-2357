package christmas;

public class Service {
	private InputView inputView;
	private OutputView outputView;

	public void start(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;

		System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
		calendar();
		order();
		calculateBefore();
		calculateAfter();
	}

	public void calendar() {
		int date = inputView.readDate(); // 날짜 입력
		List<Menu> menuRead = inputView.readOrder();
	}

	public void order() {

	}

	public void calculateBefore() {

	}

	public void calculateAfter() {

	}
}
