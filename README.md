# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

### 구현할 기능 목록

- 관련 객체
    - RaceUI (입력받기, Message 출력, 잘못된 인풋처리)
    - RaceUtil (쉼표구분 자르기, Random 수 생성)
    - Players (자동차들)
    - 자동차 (이름, position, 전진하기)
    - Race (Players, 이동, 우승자 목록 return )
    - Wrapping 객체 (CarName, Position, RestIteration, GoOrNot)

1. 자동차이름 입력받기 - RaceUI
2. 잘못된 자동차 이름 입력 Exception 처리 - RaceUI
3. 자동차이름 인풋 배열로 변경하기 - RaceUtil
4. 이동 횟수 입력 받기 - RaceUI
5. 잘못된 이동횟수 입력 Exception 처리 - RaceUI
6. 자동차 생성 - Car
7. 선수들(Cars) 생성 - Players
8. Car 목록 전달하기 - Players
9. RACE 생성(이동횟수, 참가자) - Race
10. Random 수로 전진 여부 결정 구현 - Race
11. RACE 한번의 iteration 수행하기 - Race
12. 현재 Race 상태 전달하기 - RaceUI
13. 현재 Race 상태 전달하기 - Players
14. 현재 Race 상태 출력하기 - RaceUI
15. Race 끝났는지 확인 기능 - Race
16. 우승자 Car 목록 전달하기 - Race
17. 우승자 목록 출력하기 - RaceUI
18. 전진하기 move(boolean go) - Car
19. 현재 포지션 전달하기 - Car
20. 자신의 이름 전달하기 - Car
