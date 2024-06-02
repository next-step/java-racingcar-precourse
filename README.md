# java-racingcar-precourse

## 설명
자동차 경주 게임은 사용자가 입력한 자동차들이 랜덤한 이동을 통해 경주를 벌이는 간단한 게임 프로그램 입니다.


## 기능 설명
1. Controller/Game.java 
- main(String[] args): 프로그램의 진입점입니다. 게임을 시작하고 필요한 객체들을 생성한 후 play() 메소드를 호출하여 게임을 실행합니다.
- play(): 게임을 실행하는 메소드로, 자동차 이름을 입력받고 라운드 수를 설정한 후 자동차들을 경주시킵니다. 각 라운드마다 경주 상태를 표시하고, 경주가 종료된 후 우승자를 표시합니다.
2. Model/Car.java
- move(): 자동차를 한 칸 앞으로 이동시키는 메소드입니다.
3. Model/CarList.java
- CarList(List<String> carNames): 주어진 자동차 이름 목록을 사용하여 CarList 객체를 생성하는 생성자입니다.
- getCars(): CarList에 속한 자동차 객체 목록을 반환하는 메소드입니다.
- raceOnce(): 한 라운드의 경주를 진행하는 메소드로, 각 자동차를 랜덤하게 이동시킵니다.
- findWinners(): 현재 라운드의 우승자를 찾아 반환하는 메소드입니다.
4. View/InputView.java
- getCarNames(): 사용자로부터 자동차 이름을 입력받아 배열로 반환하는 메소드입니다.
- getRounds(): 사용자로부터 경주할 라운드 수를 입력받아 반환하는 메소드입니다.
5. View/ResultView.java
- displayRaceStatus(List<Car> cars): 자동차 목록을 받아 각 자동차의 현재 위치를 표시하는 메소드입니다.
- displayWinners(List<String> winners): 우승자 목록을 받아 출력하는 메소드입니다.

## 🛠 코드 구조
```plaintext
├── src
│   ├── Controller
│   │   └── Game.java
│   ├── Model
│   │   ├── Car.java
│   │   └── CarList.java
│   ├── View
│   │   ├── InputView.java
│   │   └── ResultView.java
│   └── Application.java
