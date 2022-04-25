# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9까지 random 값을 구한 후 random 값이 4 이상일 경우 전힌하고, 3이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
* 우승자 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메세지를 출력 후 그 부분부터 입력을 다시 받는다.
* Exception이 아닌 `IllegalArgumentException`, `IllegalStateException`등과 같은 명확한 유형을 처리한다.

## 기능 목록
* Car
    * name: String
    * mileage: Int
    * drive()

* ValidUtils
    * validLength(String)
    * validNumber(String)

* CarStatus
    * STOP, GO
    * from(int): CarStatus
    * isGo(): Boolean

* Cars
    * cars: List<Car>
    * race()

* Lap
    * cars: Cars
    * getCarList: List<Car>
    * start()
    * getWinners(): List<Car>
    * findWinners(List<Car>, Int): List<Car>
    * getMaxMileage(List<Car>): Int
    * printLapResult(Car)

* Laps
    * laps: List<Lap>
    * addLap(Lap)
    * getFinalLap(): Lap

* RacingContest
    * laps: Laps
    * lapCount: Int
    * start(List<Car>)
    * result()
    * getResultMessage(List<Car>): String

* CarRacingView
    * cars: List<Car>
    * lapCount: int
    * init(): CarRacingView;
    * initCars(): List<Car>
    * initLapCount(): int

