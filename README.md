# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구 사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능 목록

-[x] main
    * RacingCarApplication
-[x] controller
    * RacingCarGameController
        * 게임 시작
-[x] domain
    * RacingCar
        * 이름을 관리한다.
        * 움직인 횟수를 반환한다.
        * RacingCar 인스턴스를 생성한다.
        * 움직인다.
    * RacingCarGroup
        * RacingCar 목록을 반환한다.
    * RacingCarMovingStatus
        * STOP
        * GO
-[x] service
    * RacingCarService
      * 문자열을 이용하여 RacingCarGroup을 생성한다.
    * RefereeService
        * RacingCarGroup을 이용하여 우승자들을 판별한다.
    * RacingCarMovingService
        * RacingCarGroup을 이용하여 RacingCar를 움직인다.
        * RandomRacingCarMovingServiceImpl
-[x] presentation
    * Display
        * 주어진 데이터를 출력 함.
    * Input
        * 사용자로부터 입력 받음.
-[x] exception
    * 각 상황에 맞는 사용자 정의 예외
