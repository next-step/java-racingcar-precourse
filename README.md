# java-racingcar-precourse

---
# Description
 1. Player chooses CarNames.
 2. Player chooses Rounds.
 3. Randomly, Each of car moves forward.
 4. Print Winner.

---
# Classes
- Application : includes main()
- Car : Car Model
- CarController : preparing Car to View
- CarService : choose Cars to move forward
- Accelator : randomly accel the car
- InputView : view inputs
- OutputView : view outputs
- Validator : process Exception

---
# Car Class
- getter and setter
- void moveForward() : distance +

# CarController
- void setCars() : set Cars for game
- void run() : start Game

# CarService
- void addCar() : make new Car
- void moveCar() : move forward Car
- void raceCar() : race Cars
- Car getCar() : get Car By Name
- ArrayList<Car> getWinner() : get Winner

# Accelator
- boolean accel() : randomly accel

# InputView
- ArrayList<String> readCarName() : read CarName from Player
- int readRound() : read Rounds from Player
- ArrayList<String> extractCarName(): Input에서 carName을 추출

# OutputView
- void printQuestCarName() : print "경주할 자동차 이름을 입력하세요.(이름은 쉼표, 기준으로 구분)"
- void printQuestRound() : print "시도할 회수는 몇회인가요?"
- void printCarDistance() : print distance of Cars
- void printWinner() : print Winner
- void printExeResult() : print "실행 결과"

# Validator
- void isCarNameValid() : 자동차 이름이 valid한지 확인
- void isCarNameLengthValid() : 자동차이름의 길이가 5이하인지 확인
- void hasCarNameSpace() : 자동차이름에 공백이 있는지 확인
- void isCarNameRangeValid() : 자동차이름이 a-zA-Z0-9_로 이루어져있는지 확인
- void isRoundRangeValid() : Round가 1보다 큰지 확인