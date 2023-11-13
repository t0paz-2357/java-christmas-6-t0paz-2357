package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
	private static final String LINE_SEPARATOR = System.lineSeparator();

	@Test
	void 모든_타이틀_출력() {
		assertSimpleTest(() -> {
			run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
			assertThat(output()).contains("<주문 메뉴>", "<할인 전 총주문 금액>", "<증정 메뉴>", "<혜택 내역>", "<총혜택 금액>",
					"<할인 후 예상 결제 금액>", "<12월 이벤트 배지>");
		});
	}

	@Test
	void 혜택_내역_없음_출력() {
		assertSimpleTest(() -> {
			run("26", "타파스-1,제로콜라-1");
			assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
		});
	}

	@Test
	void 날짜_예외_테스트() { // 날짜를 문자로 입력했을 경우
		assertSimpleTest(() -> {
			runException("a");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	void 날짜_범위_테스트() { // 날짜를 1 ~ 31 이외의 숫자로 입력했을 경우
		assertSimpleTest(() -> {
			runException("60");
			assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	void 주문_예외_테스트() {
		assertSimpleTest(() -> { // 메뉴 개수를 문자로 입력했을 경우
			runException("3", "제로콜라-a");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	void 주문_개수_테스트() {
		assertSimpleTest(() -> { // 메뉴 개수가 20개를 넘었을 경우
			runException("3", "제로콜라-23");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	void 주문_이름_테스트() {
		assertSimpleTest(() -> { // 주문한 메뉴가 메뉴판에 없을 경우
			runException("3", "오믈렛-1");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Test
	void 주문_음료만_테스트() {
		assertSimpleTest(() -> { // 주문한 메뉴가 음료밖에 없을 경우
			runException("26", "제로콜라-1");
			assertThat(output()).contains("[ERROR] 음료만 주문 시, 주문할 수 없습니다. 다시 입력해 주세요.");
		});
	}
	
	@Test
	void 만원_미만_주문_테스트() {
		assertSimpleTest(() -> {
			run("3", "아이스크림-1");
			assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
		});
	}
	
	@Test
	void 같은_메뉴_입력_테스트() {
		assertSimpleTest(() -> {
			run("3", "시저샐러드-1,시저샐러드-1");
			assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
		});
	}

	@Override
	protected void runMain() {
		Application.main(new String[] {});
	}
}
