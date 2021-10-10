# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 기능 요구사항
- carClass 
  - 각 자동차에 이름을 부여할수 있다.전진하는 자동차를 출력할 때 자동차이름을 같이 출력한다.
  - 자동차이름은 쉼표(,)를 기준으로 구분하며 이름은 5자이하만 가능하다.
- gameClass 
  - 사용자는 몇 번의 이동을 할것인지를 입력할 수 있어야한다.
- moveCar
  - 주어진 횟수동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상일 경우 전진하고, 3이하의값이면멈춘다.
- printCarsPlace
  - 자동차 현재 위치 표시
- printWinner
  - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
  - 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- error 
  - 사용자가 잘못된 값을 입력할 경우 “[ERROR]”로 시작하는 에러메시지를 출력 후 입력을 다시 받는다.
- unit test
  - domain logic unit test 추가

### 게임 실행 예시

경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)

pobi,crong,honux

시도할회수는몇회인가요?

5

실행결과
pobi:-
crong:
honux:-

pobi:--
crong:-
honux:--

프로그램 실행 결과

pobi:---
crong:--
honux:---

pobi:----
crong:---
honux:----

pobi:-----
crong:----
honux:-----

최종 우승자는 pobi, honux입니다.
