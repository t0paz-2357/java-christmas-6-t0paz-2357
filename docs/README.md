## 구현 기능
### Menu ENUM 으로 메뉴 저장

### InputView, OutputView 구현
	- 출력 메세지 중 입력을 받는 부분과 출력하는 부분 분리하여 구현.
	- InputView : 방문 날짜 입력, 메뉴 이름과 개수 입력받아 반환.
	- OutputView : 입력된 데이터에 따른 결과값 전달받아 출력.
	- Service : InputView 에서 입력한 데이터를 가지고 연산하여 OutputView 에 인자값을 넘겨주는 역할.

### InputView
	- 고객이 입력하는 날짜와 주문을 받아 Service 로 넘겨줌.
	- 입력하는 데이터가 유효한 값인지 확인하여 재입력 받을 수 있게 제한함.
	- int readDate : 방문 날짜를 입력받음. 유효하지 않은 날짜가 입력되었다면 오류 메세지를 출력하고 재입력받음.
	- List<Order> readOrder : 주문할 메뉴와 개수를 입력받는 메소드. 쉼표로 입력받은 문자열을 나누어 배열로 저장함.
	저장한 뒤, 반복되는 알고리즘 함수에 넘겨주어 주문한 메뉴의 총 개수와 유효한 주문이 입력되었는지 확인한 뒤, 오류 메세지 출력 여부를 결정하고 재입력 여부도 결정함.
	- int repeatAlgorithm : 주문 목록을 가지고 메뉴판의 메뉴가 입력이 되었는지, 메뉴 개수를 입력할 때 유효한 값이 입력되었는지를 확인하여
	출력할 주문 목록 List 에 추가하고 주문한 전체 메뉴의 개수를 반환함.
	- boolean checkOnlyDrinks : 주문한 목록에 있는 메뉴의 카테고리가 전부 음료인지 검사하여 참과 거짓을 반환함.
	- boolean checkValidDateInput : 날짜를 입력할 때 숫자를 입력하였는지,
	31일을 넘는 숫자나 1일보다 미만인 숫자가 입력되었는지를 확인하여 참과 거짓을 반환함.
	- boolean checkValidMenuName : 주문하기 위해 입력된 메뉴의 이름을 인자로 받아
	메뉴판에 있는 메뉴의 이름인지 확인하고 참과 거짓을 반환함.
	- boolean checkValidMenuCount : 주문할 메뉴의 주문 개수를 넘겨 받아 숫자가 입력되었는지,
	20보다 큰 개수를 주문했는지 확인하고 참과 거짓을 반환함.

### OutputView
	- 출력되는 모든 항목을 하나하나 메소드로 구현.
	- 출력할 값은 Service 에서 넘겨받은 값을 형식에 맞게 출력함.
	- 오류 메세지를 출력함.
	- void printVisitingDate : 입력받은 날짜를 전달받아 첫 번째로 고객님이 받은
	이벤트 혜택을 미리 보기 위한 사전 멘트를 출력함.
	- void printOrderMenu : 고객이 입력한 주문 리스트들을 형색에 맞게 출력함.
	- void printBeforeDiscountPrice : 할인 전 총주문 금액을 출력함.
	- void printOfferedChampagne : 증정 메뉴를 출력함.
	- void printEvents : 혜택 내역을 형식에 맞게 모두 출력함.
	- void printDiscountAmount : 총혜택 금액을 출력함.
	- void printAfterDiscountPrice : 할인 후 예상 결제 금액을 출력함.
	- void printEventBadge : 12월 이벤트 배지를 출력함.

### Service
	- 일종의 Controller 역할을 맡고 있음.
	- 대부분의 연산이 처리되는 곳.
	- start : inputView 와 outputView 를 변수에 대입하고 run 메소드를 실행시킴.
	- run : 고객에게 보여줄 첫 번째부터 시작하는 메소드. 이 메소드에서 날짜와 주문 메뉴를 입력받고,
	그대로 출력해주며 할인 혜택 계산 전까지의 값들을 출력함. 마지막 종료하기 전 할인 혜택을
	고려하는 메소드를 실행시키는 메소드를 출력하고 끝남.
	- input*, print* : 앞에 붙인 단어의 뜻대로 고객에게서 데이터를 입력받는 메소드와
	지정된 문자열을 반환하는 메소드임.
	- discountEvents : 할인을 받을 수 있는 항목을 각각 메소드로 구현했을 때, 해당 메소드들을 실행하여 outputView 에 전달하는 메소드
	- printOfferedChampagne : 증정 메뉴인 샴페인의 개수를 출력함. 없으면 "없음" 을 출력함.
	- calculateDiscountCost : 총혜택 금액을 계산하는 메소드.
	실행될 때 전체 주문 금액이 10000원인지 아닌지 확인하는 조건을 걸어놓아 총 혜택 금액을 계산하는데 반영함.
	- printCalculatedAfterDiscountPrice : 할인 후 예상 결제 금액을 출력함.
	- printEventBadge : 총혜택금액의 액수에 따라서 부여할 배지를 다르게 하여 반환함.
	- isTotalCostLowerThanTenThousand : 총 주문 금액이 10000원 이상인지
	미만인지 확인하여 참과 거짓을 출력함.
	- saveAppliedEvents : considerCalendar 메소드를 실행하여 할인받을 수 있는 
	혜택들을 혜택 목록에 추가하지만 만약 주문 금액이 10000원 미만이라면 혜택 목록을 초기화하여 반환함.
	- considerCalendar() : 날짜가 평일인지, 주말인지, 그리고 특별한 날인지,
	크리스마스 이전인지 확인하여 해당하는 할인 혜택 반영 메소드를 실행함.
	- calculateChristmasDDayDiscount : 크리스마스 디데이 할인 혜택 계산
	- calculateWeekendDiscountCost : 주말 할인 혜택을 반영하여 메인 메뉴 1개당 2023 원 할인함.
	- calculateWeekdayDiscountCost : 평일 할인 혜택을 반영하여 디저트 메뉴 1개당 2023 원 할인함.
	- calculateSpecialDiscountCost : 별이 붙어있는 특별한 날인지 확인하여 특별 할인 금액 1000 원을 반영함.

### Calendar, Menu, Order
	- 일종의 Model 역할을 맡고 있음
	- 각자의 필드 값을 확인하고 반환할 수 있음

### Exception
	- 오류 메세지 저장

### 마주쳤던 문제들
	- 날짜를 잘못 입력하거나 메뉴를 잘못 입력했을 때, 오류 메세지는 정상적으로 띄웠으나 재입력을 받지 않았음
	- 음료만 주문했을 때 주문이 가능했었음
	- 10000원 미만의 금액만큼 주문해도 할인 혜택을 받을 수 있었음
	- 메뉴 한 개당 할인을 하지 않고 한 개의 메뉴당 할인을 적용함