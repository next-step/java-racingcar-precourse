# 자동차 경주 게임 구현 계획 - 우아한 테크 캠프 Pro 프리코스

## 구현할 기능 목록

구현 기능 목록은 아래 문제 정의와 설계를 진행한 후 작성하였습니다.

- [x] CarName: 자동차 이름을 다루는 함수를 구현한다
- [x] CarName: 자동차 이름 유효성을 검사한다
- [x] CommaSeparatedCarNames: 콤마 구분한 자동차 이름 문자열을 다루는 함수를 구현한다
- [x] CommaSeparatedCarNames: 자동차 이름 목록 생성 시 입력 인자 유효성을 검사한다
- [x] Distance: 이동 거리를 다루는 함수를 구현한다
- [x] RacingCar: 경주 자동차를 생성, 자동차 이름과 이동 거리 요소를 다루는 함수를 구현한다
- [x] RacingCar: 랜덤값에 따라 이동 또는 정지하는 함수를 구현한다
- [x] RacingCarEntries: 참가 자동차 목록을 관리하는 함수를 구현한다
- [x] RacingCarEntries: 우승자를 이름 명단을 반환하는 함수를 구현한다
- [x] Laps: 경기에서 서킷 총 이동 횟수를 관리하는 함수를 구현한다
- [x] Laps: 생성 시 입력 인자 유효성을 검사한다
- [x] Circuit: 서킷에 경주 자동차 관리와 이동 횟수 관리하는 함수와 서킷에서 경기 완료 여부를 구현한다
- [x] Circuit: 서킷 한 바퀴 돌기, 남은 이동 횟수 줄이는 함수를 구현한다
- [x] GameView: 화면 출력 함수를 모두 구현한다
- [x] GameView: 참가 자동차들 이름을 입력 받는 함수를 구현한다
- [x] GameView: 서킷 총 이동 횟수를 입력 받는 함수를 구현한다
- [x] GameController: Circuit 와 GameView 를 호출하는 함수들을 구현한다
- [x] Context: GameBoard 와 State 사이에서 주고받을 게임 정보를 구현한다
- [x] GameState: interface 를 선언하기
- [x] GameState: 모든 게임 상태를 빈 구현체로 추가하기
- [x] GameBoard: 모든 게임 상태를 준비하고 GameBoard 를 통해서 상태를 읽고 설정하는 함수를 구현하기
- [x] GameBoard: 게임을 실행하는 함수를 구현하기
- [x] States: 각 State 마다 필요한 동작을 정의하고 구체화하기
- [x] Application: 게임에서 필요한 모든 객체를 생성하고 게임을 실행하는 세부 내용을 작성하기

<br>

## 문제 정의

사용자가 입력한 n대 자동차 이름과 이동 횟수를 입력받아 자동차들이 랜덤한 값에 따라 한 칸 전진 또는 멈춤을 이동 횟수만큼 반복합니다. 이동 횟수만큼 경주를 반복하고 가장 멀리 이동한 자동차 이름을 출력하는 게임입니다.

<br>

## 요구사항 정리

### 기능 요구사항 정리

사용자는 자동차 이름을 쉼표(`,`)로 구분하며 5자 이하 글자여야 한다.

사용자는 이동 횟수를 입력할 수 있어야 한다.

입력한 경주 횟수로 경기가 진행하는 동안 자동차들은 전진하거나 멈출 수 있어야 한다.

자동차가 전진하려면 0에서 9사이에서 random 값을 구하고 값이 4이상이면 한 칸 전진하고 3이하이면 이동하지 않아야 한다.

매 경주마다 모든 자동차들가 이동한 거리를 대시(`-`)로 표시하여야 한다.

경주를 완료하면 가장 멀리 이동한 자동차가 우승자이다.

우승자가 두 명 이상이면 쉼표(`,`)로 이름을 구분하여 출력한다.

사용자가 잘못된 값을 입력하면 `IllegalArgumentException`을 발생시키고 "`[ERROR]`"로 시작하는 에러 메시지를 출력하고 해당 입력을 다시 입력 받는다.

에러 처리는 `Exception`처럼 포괄적인 예외가 아닌 `IllegalArgumentException`, `IllegalStateException` 처럼 명확한 유형으로 처리한다.

#### 입력 요구사항

**입력**

```plain
경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5
```

**출력**

각 차수별 실행 결과

```plain
pobi: -----
woni: ---
jun: ----
```

단독 우승자 안내 문구

```plain
최종 우승자: pobi
```

공동 우승자 안내 문구

```plain
최종 우승자: pobi,jun
```

예외 상황 시 에러 문구 출력해야 한다. 에러 문구는 `[ERROR]`로 시작해야 한다.

```plain
[ERROR] 시도 횟수는 숫자여야 한다.
```

<br>

**입출력 예시**

```plain


<br>

**입출력 예시**

```plain
경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi: -
crong: 
honux: -

pobi: --
crong: -
honux: --

pobi: ---
crong: --
honux: ---

pobi: ----
crong: ---
honux: ----

pobi: -----
crong: ----
honux: -----

최종 우승자: pobi,honux
```

### 비기능 요구사항

프로그램 시작점은 `src/main/java/` 폴더의 `racinggame.Application`의 `main()` 이다.

JDK 8 버전에서 실행 가능해야 한다.

JDK 에서 제공하는 Random 과 Scanner API 를 사용하지 않고 `camp.nextstep.edu.missionutils` 패키지를 사용하여 구현해야 한다. 
* Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()` 를 사용한다.
* 값 입력은 `camp.nextstep.edu.missionutils.Console.readLine()` 을 사용한다.

`src/test/java/racinggame.ApplicationTest` 에서 정의한 Test Case 2개를 반드시 통과해야 한다.
* 필수는 아니지만 자동차 경주 게임에 가능한 경우에 Test Case 를 만드는 건 좋은 테스트 연습이 될 수 있다.

우아한 테크 코스 Java 스타일을 맞춰서 코딩해야 한다.

들여쓰기는 1 단계만 가능하다. 2 단계 이상을 넘지 않도록 구현해야 한다.

Java 8 에서 제공하는 stream API 는 사용하지 않는다.

Java 8 에서 제공하는 람다는 사용할 수 있다.

`else` 예약어를 쓰지 않는다.

함수는 10라인을 넘지 않아야 한다.
* 함수는 한 가지 일만 하도록 구현한다.

일급콜렉션을 활용해 구현한다.

모든 원시값과 문자열을 포장한다.

도메인 로직에 단위 테스트를 구현해야 한다.
* UI(`System.out`, `System.in`, `Scanner`) 로직은 단위 테스트에서 제외한다.
* MVC 패턴으로 구현하고 View, Controller 요소를 제외한 Model 요소에 단위 테스트를 만드는 데 집중한다.

핵심 로직은 UI를 담당하는 로직과 분리해야 한다.

<br>

## 애플리케이션 설계

전체 흐름을 파악하려고 동작 흐름도를 순서도로 작성하였습니다.

순서도에서 객체, 동작, 게임 상태를 분석합니다. 분석한 내용을 바탕으로 상태 다이어그램, 클래스 다이어그램, 시퀸스 다이어그램으로 상세하게 구상하였습니다.

### 동작 흐름도

[서비스 흐름도](service_flow_diagram.md)에 작성하였습니다.

### 상태 다이어그램

[상태 다이어그램](state_diagram.md)에 작성하였습니다.

### 클래스 다이어그램

[클래스 다이어그램](class_diagram.md)을 참고해 주세요.

### 시퀸스 다이어그램

[시퀸스 다이어그램](sequence_diagram.md)을 참고해 주세요.
