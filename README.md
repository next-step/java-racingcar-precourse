# java-racingcar-precourse

## 📋 기능 요구사항
### 초간단 자동차 경주 게임을 구현한다
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시키고 **"[ERROR]"** 로 시작하는 에러 메세지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception` 이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.


## 🚗 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) 
pobi,woni,jun
시도할 회수는 몇회인가요? 
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 💡구현 기능 목록

### model
자동차와 관련된 데이터 및 로직
- RacingCar

### view
사용자에게 보여지는 출력
- UserInputView
  1. 자동차 이름 입력 받기
  2. 자동차 객체로 저장
  3. 시도 횟수 입력 받기
   

- RacingGameView
   1. 실행 결과 출력
   2. 우승자 출력

### controller
사용자의 입력을 받아 Service를 업데이트, View를 통해 출력
- RacingGameController


### service
비지니스 로직 처리
- RacingGameService
   1. 자동차 경주 진행
   2. 랜덤 수에 따라 자동자 전진
   3. 우승자 결정

### exception
예외 처리
- ExceptionHandler
   1. [ERROR] 메세지 출력
   

- ErrorMsg

### util
- RandomNumberGenerator
   1. 0~9 사이 랜덤 수 생성   
  

- InputValidator
   1. 자동차 이름 입력값에 대한 유효성 검사
   2. 시도 횟수 입력값에 대한 유효성 검사


