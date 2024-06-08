# java-racingcar-precourse

# MVC model
- MVC 패턴을 기반으로 자동차 경주 미니 과제를 구현했습니다.
- 경주를 하는 자동차의 이름과 달린 거리를 상태 변수로 저장하는 Car 클래스가 존재합니다.
- Model의 역할을 하는 Race 클래스를 만들었습니다.
- View(UI 담당)의 역할을 하는 Input 클래스를 만들었습니다.
- Controller의 역할은 Main 클래스에서 이루어집니다.
- Main 클래스 내의 static void 형태의 함수들이 일부 Controller의 역할을 담당합니다.

# Input Class
- UI를 담당하는 클래스이빈다.
- MVC 패턴 중 View의 역할을 담당합니다.

## String inputPlayer() throws IllegalArgumentException
- 사용자의 입력을 통해 경주할 자동차의 이름을 입력받습니다.
- 요구 사항에 따라 자동차의 이름이 5자를 초과할 경우 IllegalArgumentException을 throw합니다.

## int inputMatch() throws IllegalArgumentException
- 사용자의 입력을 통해 경주를 진행할 횟수를 입력받습니다.
- 정수가 아닌 입력을 시도하는 경우, NumberFormatException을 catch 합니다.
- catch 하게 되면 IllgealArgumentException을 throw합니다.

## void createCarArray(String str, Car[] cars)
- Car 클래스의 객체로 구성된 cars라는 객체 배열 내의 정보를 update합니다.
- 자동차의 이름(car.name)은 inputPlayer() 메서드를 통해 입력받은 문자열을 바탕으로 초기화됩니다.
- 자동차의 거리(car.distance)는 최초에는 0으로 초기화합니다.

## int numOfPlayers(String str)
- Car 클래스의 객체 배열을 메모리에 할당하기 위해 배열의 크기를 구하기 위해 호출되는 메서드입니다.
- inputPlayer() 메서드를 통해 입력받은 경주할 자동차의 이름들을 통해 몇 개의 자동차가 경기에 참여하는지 return 합니다.

## boolean countName(String str)
- inputPlayer() 메서드에서 자동차의 이름이 5자를 초과하는지를 판단하는 메서드입니다.

# Race Class
- MVC 패턴 중 Model의 역할을 담당합니다.
- 난수를 생성하고, 게임을 진행하기 위해 Car 객체 배열 cars의 정보를 update합니다.
- 경기가 종료되면, 자동차들 중 가장 먼 거리를 구하는 로직과 우승자를 return하는 로직을 구현했습니다.
- View의 역할을 하는 printCars() 메서드도 존재합니다.

## int randGen()
- 0~9 사이의 난수를 생성합니다.
## boolean checkNum(int n)
- 정수가 4 이상이라면 true, 아니면 false를 return합니다.
## int checkGo(boolean b)
- checkNum 메서드를 호출하여 난수가 4이상인지 확인합니다.
- 4이상인 것이 확인되었다면 전진하기 위해 1을 return, 아니라면 0을 return 합니다.
## void updateCars(Car[] cars)
- 경기를 진행하며 호출되는 메서드로 앞에서 정의된 randGen(), checkNum(), checkGo() 메서드를 호출합니다.
- 호출하여 저장된 변수 값들을 기반으로 Car 객체의 상태 정보를 update합니다.
## int findMaxDistance(Car[] cars)
- 객체 배열을 매개변수로 사용하여 객체 배열에 있는 Car 객체 중 최대 distance를 구합니다.
- stream과 lambda 식을 사용하였으며, stream의 max() 는 OptionalInt를 return 합니다.
- 이를 방지하고자 orElse() 를 사용하여 만약 최대값이 null이면 MIN_VALEU를 return 하게끔 구현했습니다.
## String[] returnWinner(Car[] cars) 
- 객체 배열을 매개변수로 받아 우승자를 String 배열로 return 합니다.
- findMaxDistance() 메서드를 호출하여 최대 거리를 구하고, 최대 거리와 동일한 거리를 이동한 Car 객체의 name을 String 배열로 반환합니다.
- 이때 stream과 lambda식을 사용하였습니다.

# Main Class
- MVC 패턴 중 Controller의 역할을 담당합니다.
- inputValue() 메서드를 통해 Viewer인 Input 클래스의 i라는 객체를 생성합니다.
- doRacing() 메서드를 통해 Model인 Race 클래스의 r이라는 객체를 생성합니다.
- checkWinner() 메서드를 통해 Model인 Race 클래스의 객체를 생성하여 우승자를 확인하고 출력합니다.

## static void inputValue() throws IllegalArgumentException 
- Viewer의 역할을 하는 Input 클래스의 객체 i를 생성합니다.
- inputPlayer()와 inputMatch(), createCarArray() 메서드를 호출합니다.
- 만약 사용자가 잘못된 입력을 시도하는 경우, IllegalArgumentException을 throw합니다.
- 이는 main() 메서드에서 catch 하여 "[ERROR]"로 시작하는 message를 출력하고 정상 종료합니다.

## static void doRacing(int n, Car[] cars)
- Model의 역할을 하는 Race 클래스의 객체 r을 생성합니다.
- inputMatch()로 입력받은 경기 횟수만큼 for문을 통해 경기를 반복합니다.
- 경기를 반복하는 동안 updateCars() 메서드를 호출하여 객체 배열 내의 Car 객체의 정보를 update합니다.
- 또한 printCars() 메서드를 호출하여 실행결과를 출력할 수 있게끔 합니다.
- 가독성을 위해 한 경기가 종료된 이후 공백을 출력합니다.

## static void checkWinner(Car[] cars)
- Model의 역할을 하는 Race 클래스의 객체 r을 생성합니다.
- String 배열인 winners에 returnWinner() 메서드의 리턴 값을 저장합니다.
- 최종 우승자를 출력합니다. 만약 여러명일 경우 쉼표를 토해 구분할 수 있게끔 구현했습니다. 