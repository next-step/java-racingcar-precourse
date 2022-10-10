# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## Implemented Result

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
henry, berni, jeong
시도할 회수
3

실행 결과
henry: --
berni: --
jeong: -

henry: --
berni: --
jeong: -

henry: ---
berni: ---
jeong: --

최종 우승자: henry,berni
```

## Todo

- [x] feat: architecture design - view(input, output), domain(), controller(Application)
- [x] test: add case for Spot: {defaultSpotShouldBe1, shouldMove1}
- [x] feat: implement Spot {int at, Spot move()}
- [x] test: add case for Car {defaultCar, carNameShouldBeBetween1and5}
- [x] feat: implement Car {String name, Spot spot, void validate(String) throw E}
- [x] test: add case for Cars: {AddCar, shouldYieldWinner, shouldYieldTwoWinnersWithIdenticalSpot}
- [x] feat: implement first class collection Cars {List<Car> car, Cars addCar(Car), Car yieldWinner()}
- [x] test: add case for Input: {parseCars, IllegalArgumentInputThrowException}
- [x] feat: implement Input.{String scan(), Cars parseCars()}
- [x] fix: modify default Spot.at from 0 to 1
- [x] test: add case for Race: {createThreeCars, RollShouldMoveOrStay}
- [x] feat: implement interface RollStrategy, class {RandomStrategy, AlwaysWinStrategy}
- [x] feat: implement Race {Cars cars, RollStrategy, rollStrategy, Cars enrollCars(String[] names), RollResult roll(Car)
  }
- [x] feat: implement Application logic
- [x] fix: modify Input.parseCars -> parseNames to return String[]
- [x] test: add case for ShouldConcatNamesWithComma
- [x] feat: implement Cars {String names(), String separator(ListIterator<Car>)}
- [x] feat: implement iterator at Cars, Race{rolls(), Cars yieldWinner()}
- [x] feat: implement Output.printCars(Cars)
- [x] feat: implement Output.track() to draw tracks
- [x] fix: modify default Spot.at from 1 to 0
- [x] refactor: rename scanNames to scanCars, add recursive try-catch to scanCars
- [x] fix: remove redundant case, modify default Spot from 1 to 0
- [x] refactor: split Input.parseCars from Input.scanCars
- [x] test: rename RollShouldMoveOrStay to RollWithRandomStrategyMoveOrStay, add RollsWithAlwaysWinStrategy
- [x] test: add cases Input {parseCars, parseTryNumber}
- [x] feat: implement GameResult {Spot maxSpot, Cars winners, GameResult addWinner(Car)}
- [x] refactor: split yieldWinner to yieldFinalResult and yieldRoundResult
- [x] refactor: split main logic to controller.RaceApp
- [x] refactor: gather magic number to Scale, literal string to Payload