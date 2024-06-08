# java-racingcar-precourse

# 대략적인 진행 계획

Car 에 대한 클래스부터 작성 후 점점 큰 범위로 나아가는 방식으로 진행.


# 기능에 따른 도메인 분류

## RaceManager.class

### member

- InputController
- OutputController
- CarManager

### function

- void : raceSetup()
- void : doRace()

## InputController.class

### member

- Scanner

### function

- void : inputCarName()

사용자에게 입력에 대한 문구를 출력한다.
, 을 단위로 최대 n대의 자동차의 이름을 입력받는다.

throw -> IllegalArgumentException

- void : inputRaceCount()

사용자에게 시도할 횟수에 대한 문구를 출력한다.
int 형식의 시도 횟수를 입력받는다.

throw -> IllegalArgumentException

## OutputController.class

### function

- void : printRaceLog(string,int)

한번의 경주 결과를 출력한다.

- void : printRaceWinner(string ...)

최종 우승자를 출력한다.

### RaceManager.class

### member

- CarList<Car>

- RandomMaker

### function

- void : addCar(string)
새로운 자동차를 추가한다.

- Set : getCarList()
자동차 리스트를 반환한다.

- void : race()
레이스를 실행한다.

- Map : getRaceLog()
레이스 로그를 얻는다.

- Set : getFastCarName()
가장 빠른 차들의 이름을 얻는다.

## Car.class

### member

- name <string>
- position <int>
- excelCondition <int>

### function

- void : setExcelCondition(int)
position이 증가하는 조건을 변경

- void : doExcel(int)
position을 증가시킨다.

- void : getPosition()
현재 위치를 반환한다.

## RandomMaker.class

### function

- int : getRandom()

0~9 사이의 랜덤한 값을 반환한다.