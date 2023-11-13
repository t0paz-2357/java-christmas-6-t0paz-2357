## 구현할 기능
- Menu ENUM 으로 메뉴 저장

- InputView, OutputView 구현
	- 출력 메세지 중 입력을 받는 부분과 출력하는 부분 분리하여 구현
	- InputView : 방문 날짜 입력, 메뉴 이름과 개수 입력받아 반환
	- OutputView : 입력된 데이터에 따른 결과값 전달받아 출력
	- Service : InputView 에서 입력한 데이터를 가지고 연산하여 OutputView 에 인자값을 넘겨주는 역할

- InputView
	- 고객이 입력하는 날짜와 주문을 받아 Service 로 넘겨줌

- OutputView
	- 출력되는 모든 항목을 하나하나 메소드로 구현
	- 출력할 값은 Service 에서 넘겨받은 값을 형식에 맞게 출력함
	- 오류 메세지를 출력함

- Service
	- 일종의 Controller 역할을 맡고 있음
	- 대부분의 연산이 처리되는 곳

- Calendar, Menu, Order
	- 일종의 Model 역할을 맡고 있음
	- 각자의 필드 값을 확인하고 반환할 수 있음