package christmas;

public class Application {
	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		Service service = new Service();
		
		service.start(inputView, outputView);
	}
}
