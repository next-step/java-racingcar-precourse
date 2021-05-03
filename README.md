# 자동차 경주 게임

## 기능 구현

- 자동차(Car)
  - 자동차는 이름(Name)과 위치(Position)를 가지고 있다.
  - 이름(Name)  
    - 자동차 이름은 5자 이하만 가능하다.
  - 위치(Position)
    - 최소 위치는 0이다.
    - 위치가 증가될때마다 현재 위치의 + 1에 해당되는 새로운 객체로 반환한다.
    - 다른 위치 값과 비교하여 큰 수를 반환한다.
- 규칙(MoveRule)
  - 반환되는 0에서 9 사이에서 랜덤한 값에 따라 전진 또는 멈춘다. 
  - 전진하는 조건은 다음과 같다.
    - forward(전진) : random >= 4
    - stop(멈춤) : random <= 3
- 라운드(Round)
  - 라운드(주어진 횟수)마다 n대의 자동차에 대한 레이스(전진 또는 멈춤)을 기록을 관리한다.
- 라운드 일급 컬렉션(Rounds)
  - 매 라운드마다 자동차들의 레이싱 결과를 저장한다.
  - 우승자를 가리기 위한, 마지막 라운드를 반환한다.
- 자동차 일급 컬렉션(Cars)
  - 자동차 이름은 쉼표(`,`) 기준으로 구분하여 생성한다.
  - 해당 라운드의 자동차들 중 최대 위치를 반환한다.
- 우승자 일급 컬렉션(Winners)
  - 라운드에 해당되는 우승자를 구한다.
    - 라운드의 자동차 최대 위치(Position)을 기준으로 우승자를 구한다.
- UI
  - InputView
  - ResultView
  - LacingGameApplication
  
---

## 1. 기능 요구사항

- ~~주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.~~
- ~~각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.~~
- ~~자동차 이름은 쉼표(`,`)를 기준으로 구분하며 이름은 5자 이하만 가능하다.~~
- ~~사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.~~
- ~~전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.~~
~~- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.~~

## 2. 프로그램 실행 결과

```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) 
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## 3. 프로그래밍 요구사항 - 1주차와 동일한 기준

- [자바 코드 컨벤션을 지키면서 프로그래밍한다.](https://naver.github.io/hackday-conventions-java/)
- `indent`(인덴트, 들여쓰기) `depth`를 `2`가 넘지 않도록 구현한다. `1`까지만 허용한다.
    - 예를 들어 `while` 문 안에 `if` 문이 있으면 들여쓰기는 `2`이다.
    - 힌트: `indent`(인덴트, 들여쓰기) `depth`를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 `stream api`를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
    - 힌트: `if` 조건절에서 값을 `return`하는 방식으로 구현하면 `else`를 사용하지 않아도 된다.
    - `else`를 쓰지 말라고 하니 `switch/case`로 구현하는 경우가 있는데 `switch/case`도 허용하지 않는다.
- 함수(또는 메소드)의 길이가 `10` 라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

## 4. 프로그래밍 요구사항 - 2주차 추가

- [일급콜렉션을 활용해 구현한다과.](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
- [모든 원시값과 문자열을 포장한다.](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4)

## 5. 프로그래밍 요구사항 - 단위 테스트

- 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in, Scanner) 로직은 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
- JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해
사용법을 익힌 후 JUnit5 기반 단위 테스트를 구현한다.

## 6. 미션 저장소 및 진행 요구사항

- 미션은 [GitHub 저장소](https://github.com/next-step/java-racingcar-precourse) 를 `fork/clone`해 시작한다.
- 기능을 구현하기 전에 [java-racingcar-precourse/README.md](https://github.com/gmoon92/java-racingcar-precourse/blob/master/README.md) 파일에 구현할 기능 목록을 정리해 추가한다.
- git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/next-step/nextstep-docs/blob/master/precourse) 문서를 참고한다.

## 7. 2차 미션 마감 및 기준

- 2021년 5월 4일(화) 23시 59분까지 GitHub을 통한 미션 제출과 메일전송까지 완료해야 한다
- 2021년 5월 5일(수) 00시 이후 추가 push도 허용하지 않는다.
- 2021년 5월 5일(수) 00시 이후 제출한 경우 미션을 제출하지 않은 것으로 한다.

---

## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
