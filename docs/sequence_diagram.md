# 시퀸스 다이어그램

## Application.main()

GameBoard 를 초기화하고 게임을 실행한다.

```mermaid
sequenceDiagram
    actor Player
    participant Application
    participant GameView
    participant GameController
    participant GameBoard
    participant Circuit
    
    Player --> Application: main()
    Application -->> GameView: new
    Application -->> Circuit: new
    Application -->> GameController: new (GameView, Circuit)
    Application -->> GameBoard: new (GameController)
    Application -->> GameBoard: run()
```

## GameBoard.run() - INIT

**Init 게임 상태**일 때 수행하는 과정을 설명합니다.

게임 상태 객체를 준비하고 초기 게임 상태로 상태를 설정하고 게임 동작을 반복한다.

✔️ Application 에서 `run()` 요청한 부분은 생략합니다.

```mermaid
sequenceDiagram
    participant GameBoard
    participant InitState
    participant GameController

    GameBoard -->> GameBoard: initializeGameStates()
    GameBoard -->> GameBoard: setState(InitState)

    loop state != ExitState
        GameBoard -->> InitState: viewUpdate()

        GameBoard -->> InitState: readInput()
        InitState -->> GameBoard : Context(empty)

        GameBoard -->> InitState : evaluateData(context)

        GameBoard -->> InitState: nextState()
        InitState -->> GameBoard: setState(InputCarNamesState)
    end
```

## GameBoard.run() - INPUT_CAR_NAMES

**InputCarNames 게임 상태**일 때 수행하는 과정을 설명합니다.

참가 자동차 이름들을 입력 받는 상태를 정의합니다.

✔️ Application 에서 `run()` 요청한 부분은 생략합니다.

```mermaid
sequenceDiagram
    participant GameBoard
    participant InputCarNamesState
    participant GameController
    participant GameView
    participant CommaSeparatedCarNames
    participant Context
    participant Circuit
    participant RacingCarEntries
    participant RacingCar
    participant CarName
    participant Distance

    loop state != ExitState
        GameBoard -->> InputCarNamesState: viewUpdate()
        InputCarNamesState -->> GameController: printCarNamesInputRequestMessage()
        GameController -->> GameView: printCarNamesInputRequestMessage()

        GameBoard -->> InputCarNamesState: readInput()
        InputCarNamesState -->> GameController: readCarNames()
        GameController -->> GameView: readCarNames()

        loop occur IllegalArgumentExpception
            GameView -->> GameView: printCarNamesErrorMessage()
            GameView -->> GameView: readCarNames()
            GameView -->> CommaSeparatedCarNames: new(names)
        end

        GameView -->> GameController : CommaSeparatedCarNames
        GameController -->> InputCarNamesState : CommaSeparatedCarNames
        InputCarNamesState -->> Context : new(CommaSeparatedCarNames)
        InputCarNamesState -->> GameBoard : Context

        GameBoard -->> InputCarNamesState : evaluateData(context)
        InputCarNamesState -->> GameController : registerCarEntries(context.carnames)
        GameController -->> Circuit : registerCarEntries(carnames)

        loop foreach name in CommaSeparatedCarNames
            Circuit -->> RacingCarEntries : addNewRacingCar(name)
            RacingCarEntries -->> RacingCar : new RacingCar(name)
            RacingCar --> CarName : new CarName(name)
            RacingCar --> Distance : new Distance()
        end

        GameBoard -->> InputCarNamesState : nextState()
        InputCarNamesState -->> GameBoard : setState(InputLapCountState)
    end
```

## GameBoard.run() - INPUT_LAP_COUNT

**InputLapCount 게임 상태**일 때 수행하는 과정을 설명합니다.

이번 경주에서 트랙을 자동차가 주행할 총 이동 횟수를 입력 받는 상태를 정의합니다.

✔️ Application 에서 `run()` 요청한 부분은 생략합니다.

```mermaid
sequenceDiagram
    loop state != ExitState
        GameBoard -->> InputLapCountState : viewUpdate()
        InputLapCountState -->> GameController : printLapCountInputRequestMessage()
        GameController -->> GameView : printLapCountInputRequestMessage()

        GameBoard -->> InputLapCountState : readInput()
        InputLapCountState -->> GameController : readLapCount()
        GameController -->> GameView : readLapCount()

        loop occur IllegalArgumentExpception
            GameView -->> GameView: printLapCountErrorMessage()
            GameView -->> GameView: readLapCount()
            GameView -->> Laps : new(count)
        end

        GameView -->> GameController : Laps
        GameController -->> InputLapCountState : Laps
        InputLapCountState -->> Context : new (Laps)
        InputLapCountState -->> GameBoard : Context
        
        GameBoard -->> InputLapCountState : evaluateData(context)
        InputLapCountState -->> GameController : registerLapCount(context.laps)
        GameController -->> Circuit : registerLapCount(laps)
        Circuit -->> Circuit : registerLapCount(laps)
        Circuit -->> Laps : setLaps(laps)

        GameBoard -->> InputLapCountState : nextState()
        InputLapCountState -->> GameBoard : setState(OnLapState)
    end
```

## GameBoard.run() - ON_LAP

**OnLap 게임 상태**일 때 수행하는 과정을 설명합니다.

한 번의 경주를 수행하는 상태를 정의합니다.

✔️ Application 에서 `run()` 요청한 부분은 생략합니다.

```mermaid
sequenceDiagram
    loop state != ExitState
        GameBoard -->> OnLapState : viewUpdate()

        GameBoard -->> OnLapState : readInput()
        OnLapState -->> GameBoard : Context(empty)

        GameBoard -->> OnLapState : evaluateData(context)

        OnLapState -->> GameController : takeALap()
        GameController -->> Circuit : takeALap()
        Circuit -->> RacingCarEntries : takeALap()

        loop foreach car in Cars
            RacingCarEntries -->> RacingCar : moveOrStop()
            RacingCar -->> RacingCar : canMove()
            opt canMove is true
                RacingCar -->>+ RacingCar : move()
                RacingCar -->>- Distance : increase()
            end
        end 

        Circuit -->>+ Circuit : decreaseLaps()
        Circuit -->>- Laps : decrease()

        GameBoard -->> OnLapState : nextState()
        OnLapState -->> GameBoard : setState(LapResultState)
    end
```

## GameBoard.run() - LAP_RESULT

**LapResult 게임 상태**일 때 수행하는 과정을 설명합니다.

실행 시점까지 자동차들이 이동한 결과를 출력하는 상태를 정의합니다.

✔️ Application 에서 `run()` 요청한 부분은 생략합니다.

```mermaid
sequenceDiagram
    loop state != ExitState
        GameBoard -->> LapResultState : viewUpdate()
        LapResultState -->> GameController : printLapResult()
        GameController -->> GameView : printLapResultBanner()

        loop foreach car in cars
            GameController -->> Circuit : getRacingCarAt(index)
            Circuit -->> RacingCarEntries : getRacingCarAt(index)
            RacingCarEntries -->> Circuit : RacingCar
            Circuit -->> GameController : RacingCar
            GameController -->> GameView : printCurrentResult(racing_car)
            GameView -->> RacingCar : toCarNameString()
            RacingCar -->> CarName : toString()
            GameView -->> RacingCar : toDistanceString()
            RacingCar -->> Distance : toString()
        end

        GameBoard -->> LapResultState : readInput()
        LapResultState -->> GameBoard : Context(empty)

        GameBoard -->> LapResultState : evaluateData(empty)

        GameBoard -->> LapResultState : nextState()
        LapResultState -->> GameController : isFinished()
        GameController -->> Circuit : isFinished()
        Circuit -->> Laps : getLaps()
        Circuit -->> GameController : true/false
        GameController -->> LapResultState : true/false

        opt finished
            LapResultState -->> GameBoard : setState(WinnerResultState)
        end

        alt not finished yet
            LapResultState -->> GameBoard : setState(OnLapState)
        end
    end
```

## GameBoard.run() - WINNER_RESULT

**WinnerResult 게임 상태**일 때 수행하는 과정을 설명합니다.

최종 우승자를 출력하는 상태를 정의합니다.

✔️ Application 에서 `run()` 요청한 부분은 생략합니다.

```mermaid
sequenceDiagram
    loop state != ExitState
        GameBoard -->> WinnerResultState : viewUpdate()
        WinnerResultState -->> GameController : printWinnerResult()
        GameController -->> GameView : printWinnerResultBanner()
        GameController -->> Circuit : getWinnerNames()
        Circuit -->> RacingCarEntries : getWinnersNames()
        RacingCarEntries -->> RacingCarEntries : sort()

        loop foreach car in cars
            RacingCarEntries -->> RacingCarEntries : getRacingCarAt(index)
            RacingCarEntries -->> RacingCar : getDistance()
            RacingCarEntries -->>+ RacingCarEntries : compareDistance(distance)
            RacingCarEntries -->>- Distance : compareTo()

            opt append car name if car has longest distance
                RacingCarEntries -->> CommaSeparatedCarNames : append(name)
            end
        end

        RacingCarEntries -->> Circuit : CommaSeparatedCarNames
        Circuit -->> GameController : CommaSeparatedCarNames
        GameController -->> GameView : printWinnerNames(carnames)
        GameView -->> CommaSeparatedCarNames : toString()

        GameBoard -->> WinnerResultState : readInput()
        WinnerResultState -->> GameBoard : Context(empty)

        GameBoard -->> WinnerResultState : evaluateData(context)
        
        GameBoard -->> WinnerResultState : nextState()
        WinnerResultState -->> GameBoard : setState(CloseState)
    end
```

## GameBoard.run() - CLOSE

**Close 게임 상태**일 때 수행하는 과정을 설명합니다.

게임 종료 메시지를 출력하는 상태를 정의합니다.

게임 흐름을 종료하려고 게임 종료 상태(ExitState)로 설정합니다.

✔️ Application 에서 `run()` 요청한 부분은 생략합니다.

```mermaid
sequenceDiagram
    GameBoard -->> CloseState : viewUpdate()
    CloseState -->> GameController : printCloseMessage()
    GameController -->> GameView : printCloseMessage()

    GameBoard -->> CloseState : readInput()
    CloseState -->> GameBoard : Context(empty)

    GameBoard -->> CloseState : evaluateData(context)

    GameBoard -->> CloseState : nextState()
    CloseState -->> GameBoard : setState(ExitState)
```