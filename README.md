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
- GameService : managing Round
- Accelator : randomly accel the car
- InputView : view inputs
- OutputView : view outputs
- Validator : process Exception

---
# Car Class
- getter and setter
- void moveForward() : distance +

# CarController

# CarService
- void addCar() : make new Car
- void moveCar() : move forward Car
- void raceCar() : race Cars
- Car getCar() : get Car By Name

# GameController
- void run() : start Game
- getWinner() : get Winner

# Accelator
- boolean accel() : randomly accel

# InputView
- String readCarName() : read CarName from Player
- int readRound() : read Rounds from Player

# OutputView
- void printQuestCarName() : print "경주할 자동차 이름을 입력하세요.(이름은 쉼표, 기준으로 구분)"
- void printQuestRound() : print "시도할 회수는 몇회인가요?"
- void printCarDistance() : print distance of Cars
- void printWinner() : print Winner

# Validator