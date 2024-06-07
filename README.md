# java-racingcar-precourse


## 기능 목록

**MVC패턴**
- Model: 데이터와 관련된 부분
- View: 사용자한테 보여지는 부분
- Controller: Model과 View를 이어주는 부분

- Model은 Controller와 View에 의존하지 않아야 한다.
- View는 Model에만 의존해야 하고, Contoller에 의존하면 안된다.
- View는 Model로부터 데이터를 받을 대는 사용자마다 다르게 보여주어야 하는 데이터에 대해서만 받아야 한다.
- Controller는 Model가 View에 의존해도 된다.
- View가 Model로부터 데이터를 받을 때, 반드시 Controller에서만 받아야 한다.

### Model

- 자동차 DTO 생성
    - member field: 이름, methods: 전진
        - 전진 method는 0-9사이 랜덤값을 구하여 4 이상인 경우를 전진함으로 정한다.
- 게임 DTO 생성
    - member field: 횟수, methods: 중간 결과 출력
        - member method를 통해 print를 하는 method

### Controller

- gameController 생성
    - 자동차 이름 5자 이내로 쉼표를 기준으로 구분하여 입력받기
    - 입력 받은 이름을 토대로 자동차 객체 생성하기
    - 시도 횟수 입력받기
    - 공동 수상이 가능한 우승 자동차 결정하기

### View
- InputView
- OutputView
- 게임 상태를 횟수마다 출력하는 기능 구현하기
- 공동 수상일 경우 쉼표로 구분하여 우승 자동차 출력하기
- 에러일 경우 정확하고 구체적인 에러 클래스와 "[ERROR]"로 시작하기



## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다 시 받는다.
  -IllegalArgumentException Exception 이 아닌 IllegalArgumentException , IllegalStateException 등과 같은 명확한 유형을 처리한다

## 프로그램 요구 사항

- JDK 17 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application 의 main() 이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit() 를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Google Java Style Guide을 원칙으로 한다.
    - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 힌트: MVC 패턴 기반으로 구현한 후, View와 Controller를 제외한 Model에 대한 단위 테스트 추가에 집중한다.



## Branching Strategy

브랜치 전략은 Github Flow를 따른다.
기능을 추가하는 Feature 단위로 branch를 만들어 단일 branch로 빠른 배포를 가능하게 한다.

## 커밋 단위

커밋의 기본 원칙은 하나의 액션, 하나의 커밋
커밋 메세지의 경우 scope는 선택사항이므로 생략