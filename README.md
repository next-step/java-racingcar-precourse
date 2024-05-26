# java-racingcar-precourse
***
## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다
  시 받는다.
  - Exception 이 아닌 IllegalArgumentException , IllegalStateException 등과 같은 명확한 유형을 처리한다.
***
## 구현할 기능 목록
> MVC 패턴을 따른다


- Model(Car)
  - name을 인수로 생성하는 생성자
  - position getter
  - name getter
  - Car name이 5자를 초과할 시 오류를 발생하는 기능
  - randomNum의 값이 4이상이면 position을 +1 해주는 move 기능
- Model(Race)
  - Car 리스트와 시도 횟수를 인수로 가지는 생성자
  - Car 객체당 하나씩 0~9 사이의 랜덤 인수를 가진 move()를 실행하는 기능
  - Car의 position중 가장 큰 수에 해당하는 Car들을 리스트 형태로 반환하는 getWinner기능
  - cars getter
  

- View(InputView)
  - 시도할 횟수를 입력받아 리턴하는 getAttempts()
  - ','를 기준으로 자동차 이름을 입력받아 리턴하는 getCarNames()
- View(ResultView)
  - 레이스 결과를 출력하는 ResultView()
  - 최종 우승자를 출력하는 printWinners()


- Controller(Application)
  - 전체적인 코드를 종합하여 실행하는 main()
---
## Test 리스트
- Cartest model에서 Car 이름이 없거나 5자를 초과했을 때 오류를 출력하는지 테스트 기능 구현
- 무작위 값이 4이상일때 position이 1 증가하고, 4보다 작을때는 position이 증가하지 않는지 테스트
- 3개의 차가 있을 때, 우승자의 postion보다 다른 차들의 position이 적은지 확인하는 테스트
> 테스트 결과 문제 없음