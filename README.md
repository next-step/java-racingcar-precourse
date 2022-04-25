# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록
### Car
: 레이싱카 객체
* CarName(이름), position (위치) 2개의 필드
* moveOrStop() : 랜덤 숫자 결과 4이상 이면 move 함수 호출
* printCarNameandPosition() : 레이싱카의 이름과 현재 위치를 출력
* move() : 현재 위치를 1 만큼 올림
* createRandomNumber() : 1~9 랜덤 숫자를 생성하여 반환
* getPosition() : position 반환
* getName() : name 반환
### CarName
* Car 클래스에서 name 생성 규칙을 보장하는 name 의 포장 객체.
### Cars
* Car 객체를 리스트 형태로 관리하기 위한 클래스
* getCarList() : 레이싱카 리스트를 반환
* setAttendCarList() : 게임에 참가하는 레이싱카를 set 하는 함수
* inputCarsName() : 레이싱카 이름 입력
* setCarsName(String[]) : 레이싱카의 이름이 생성되면 addCar 함수를 호출하여 리스트에 등록
* addCar(Car) : 이름이 생성된 차량을 리스트에 추가
### Game
: 0이상의 게임 라운드를 필드로 갖는 객체로 게임 시작시 생성됨
* getRound() : 생성된 객체의 게임 라운드 값을 반환한다.
### RacingGame
: 레이싱을 관리하는 class
* start() : 게임을 시작 할 수 있도록 차량 세팅을 포함하여 레이스 시작과 결과를 보여줌
* printWinner(ArrayList<Car>) : 최종 우승자 출력
* getWinnerList(ArrayList<Car>) : Max Position을 확인하여 최종 우승자 리스트를 String 으로 반환
* setWinnerList(Car car) : Max Position과 비교하여 같은 경우 winnerList에 추가
* setMaxPosition(ArrayList<Car>) : 전체 참가자 리스트 중에서 Max Position을 세팅함.
* isMax(Car) : Max Position 값과 현재 레이싱카의 Position을 비교하여 Max Position 세팅
* run(ArrayList<Car>, round) : round 만큼 runCar() 함수 실행
* runCar(ArrayList<Car>) : 레이싱카 별 경주 및 현재 포지션 출력
* setGameRound() : 라운드 생성 규칙에 맞게 진행할 게임의 객체를 생성
* inputGameRound() : 생성할 라운드를 입력 받는 함수
  
