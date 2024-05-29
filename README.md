# java-racingcar-precourse
# 자동차 경주 게임

1. 자동차 클래스(Model.Car)
- 이름 및 이동 거리 정보를 담고 있다.

View
1. 에러 메시지 클래스(View.ErrorMessage)
- Exception 발생 시 메시지를 출력하고 다시 입력을 받는다.
2. 입력 클래스(View.Input)
- 자동차의 이름 및 시도할 횟수를 입력받는다.
3. 출력 클래스(View.Output)
- 경주 실행 결과 및 우승자를 출력한다.

Controller
1. 조절 클래스(Controller.Controller)
- 이동 회수를 입력받고, 그에 맞게 움직인다.

1. Application 클래스(Application)
- main 함수가 있으며, 코드를 실행하는 역할을 한다.