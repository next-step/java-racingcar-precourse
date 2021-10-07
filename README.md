# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---
### 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 “[ERROR]”로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.

---
### 구현할 기능 목록
- 관련 객체
  - RaceUI (입력받기, Message 출력, 잘못된 인풋처리)
  - RaceUtil (쉼표구분 자르기, Random 수 생성)
  - Players (자동차들) 
  - 자동차 (이름, position, 전진하기)
  - Race (Players, 이동, 우승자 목록 return )

1. 자동차이름 입력받기 - RaceUI
2. 잘못된 자동차 이름 입력 Exception 처리 - RaceUI
3. 자동차이름 인풋 배열로 변경하기 - RaceUtil
4. 이동 횟수 입력 받기 - RaceUI
5. 잘못된 이동횟수 입력 Exception 처리 - RaceUI
6. 자동차 생성 - Car
7. 선수들 생성 - Players
8. 선수 추가하기 - Players 
9. Car 목록 전달하기 - Players
10. RACE 생성(이동횟수, 참가자) - Race
11. Random 수로 전진 여부 결정 구현 - Race
12. RACE 한번의 iteration 수행하기 - Race 
13. Race 끝났는지 확인 기능 - Race
14. 우승자 Car 목록 전달하기 - Race
15. 전진하기 move(boolean go) - Car 
16. 현재 포지션 전달하기 - Car 
17. 자신의 이름 전달하기 - Car
