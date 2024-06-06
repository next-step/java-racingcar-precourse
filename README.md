# java-racingcar-precourse

## 기능 목록

Getter, Setter 생략

### 1. model 패키지

#### Car 클래스

* 필드: `String name`, `int position`
* 메서드
  * `public Car(String name)`: 생성자 메서드
    * 에러처리: 자동차 이름이 5자 이하가 아닌 경우 `IllegalArgumentException` 발생
  * `public void move()`: 무작위 값이 4 이상일 경우 전진
  * `public void resetPosition()`: `position`값을 초기화하는 메서드



### 2. view 패키지

#### GameView 클래스

* 메서드
  * `public List<String> getCarNames()`: 자동차 이름 입력받아서 `Utils.parseCarNames`를 통해 자동차 이름 리스트 반환
  * `public int getNumberOfMoves()`: 이동 횟수 입력받는 메서드
    * 에러처리: 숫자가 아닌 경우 `IllegalArgumentException` 발생
  * `public void printCarPostion(List<Car> cars)`: 게임 진행 중 차의 위치를 출력하는 메서드
  * `public void printWinners(List<Car> winners)`: 우승자를 출력하는 메서드



### 3. controller 패키지

#### GameController 클래스

* 필드: `List<Car> cars`,  `GameView view`, `GameService service`, `int numberOfMoves`
* 메서드
  * `public GameController(GameView view, GameService service)`: 생성자
  * `public void initializeGame()`: 게임 초기화 메서드
  * `public void startGame()`: 게임 시작 메서드
  * `public void playGame()`: 게임 진행 메서드
  * `public void printResult()`: 게임 결과 출력 메서드



### 4. service 패키지

#### GameService 클래스

* 메서드
  * `public void moveCars(List<Car> cars)`: 자동차들을 전진시키는 메서드
  * `public List<Car> findWinners(List<Car> cars)`: 자동차들 중 우승자를 찾는 메서드
    * 에러처리: 우승자가 없는 경우 `IllegalStateException` 발생
  * `public List<Car> createCarObject(List<String> carNames)`: 자동차 이름 리스트로 `Car` 객체를 생성하는 메서드



### 5. util 패키지

#### RandomNumberGenerator 클래스

* 메서드
  * `public int generate()`: 0에서 9 사이의 무작위 값을 생성하는 메서드

#### CarNamesParser 클래스

* `public static List<String> parse(String input)`: 입력된 문자열을 파싱해서 자동차 이름의 List를 반환하는 메서드
  * 에러처리: 잘못된 input인 경우 `IllegalArgumentException` 발생





---

## 과제 요구 사항

### 과제 진행 요구 사항

* 미션은 숫자 야구 저장소를 포크하고 클론하는 것으로 시작한다.
* **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
* Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
  * [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.

#### Formating of commit message

```git
<type>(<scope>): <subject>
<BLANK LINE>
<body>
<BLANK LINE>
<footer>
```

커밋 메시지는 100자를 넘을 수 없음.

##### Allowed type

- feat (feature)
- fix (bug fix)
- docs (documentation)
- style (formatting, missing semi colons, …)
- refactor
- test (when adding missing tests)
- chore (maintain)





### 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  * `Exception` 이 아닌 `IllegalArgumentException` , `IllegalStateException` 등과 같은 명확한 유형을 처리한다.





### 실행 결과

```text
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



### 프로그래밍 요구사항 1

* JDK 17 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 `Application`의 `main()`이다.
* `build.gradle`파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그래밍 요구사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.



### 프로그래밍 요구사항 2

* 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
  * 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  * 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
* indent depth를 3이 넘지 않도록 구현한다. 2까지만 허용
  * 예를 들어, while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라
* JUnit5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
* 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
  * [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
  * [AssertJ User Guide](https://assertj.github.io/doc/)
  * [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
  * [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)



### 프로그래밍 요구사항 3

* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  * 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* else 예약어를 쓰지 않는다.
  * else를 쓰지 말라고 하니 switch/case로 구현한느 경우가 있는데 switch/case도 허용하지 않는다.
  * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
  * 힌트: MVC 패턴 기반으로 구현한 후, View와 Controller를 제외한 Model에 대한 단위 테스트 추가에 집중한다.
