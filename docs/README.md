## 기능 요구 사항
### 사용자 입력
- 레이싱 횟수 를 입력
- 자동차 이름을 여러대 인 경우 쉼표(,)를 기준으로 5글자 이하로 입력

### 상세
- 자동차는 이름을 가지고 있다.
- 주어진 횟수 동안 n 대의 자동차는 move or stop
- 전진 조건은 0 ~ 9 사이의 random 값 에서 일정 값 이상이면 move , 일정 값 이하면 stop
- Exception 이 아닌 명확한 유형의 Exception 으로 처리

### 출력
- 전진하는 자동차를 출력할때 자동차 이름을 같이 출력
- 게임 완료 한후 우승자를 출력
- 우승자가 복수 인경우 쉼표(,) 로 이름을 구분

### 에러 발생
- 사용자가 잘못된 값을 입력한 경우 IllegalArgumentException 를 발생
- Exception 발생 시 "[ERROR]" 로 시작하는 에러 메시지를 출력
- 에러 발생한 부분 부터 다시 입력

----------------------
## 역할 class

### Energy class
- Energy 는 int 값을 가지며, VO 객체다.
- Energy 는 서로 비교할수 있다.

### EnergyGenerator class
- EnergyGenerator 는 일정범위를 주어지면 해당 범위에서 Energy 를 생성한다.
- ~~EnergyGenerator 는 입력 값 만큼 Energy 를 생성한다.~~
- EnergyGenerator 의 create 함수 호출 시 Energy 를 생성한다.

### Engine class
- Engine 는 움직이는데 필요한 Energy 기준이 되는 Gauge 값을 가진다
- Engine 는 외부로 부터 Energy 를 입력받아 동작 여부를 확인하는 메소드를 가진다.

### Position class
- Position 는 VO 객체이다.
- Position 에서 move 함수 호출시 파라미터에 맞는 새로운 Position object 를 리턴한다.
- Position Object 를 String 로 출력시 멤버 변수 값에 맞게 hyphen 을 출력한다.
- Position 객체끼리 비교가 가능해야 하며 잘못된 비교값인 경우 에러가 발생한다.

### Car class
- Car 는 이름 과 움직일수 있는 최소 Energy gauge 를 갖는다.
- Car 는 외부로 부터 Energy 를 주입 받고 최소 Energy gauge 보다 움직인다.
- Car 는 초기 Position 값을 갖는다.
- Car 가 움직일때 마다 Position 값도 증가한다.
- isMove 메소드의 인자값은 null 이 될수 없다.
- Car class 를 String 으로 변환시 이름과 거리를 출력한다.
- Car 객체 끼리 승자를 판별할수 있다.

### Name Class
- Name class 는 VO 객체이며, 생성시 String 값을 받는다.
- String 으로 출력할수 있어야 한다.
- 입력값은 1보다 작을수는 없다. 
- 
### Presenter Class
- 입력과 출력을 담당하며 자동차 이름을 입력 받으면 입력된 이름의 Array 를 반환한다.
- 사용자가 쉼표를 기준으로 입력한 갯수만큼 반환하는 갯수도 같아야 된다.
- 레이싱 시도 횟수를 위한 입력과 출력도 가지고 있다.
- 레이싱 시도 횟수 입력시 잘못된 값 일력시 에러를 발생한다.

### RacingCount class
- 레이싱 횟수를 가진 class 로써 VO 객체 이며, 생성시 Integer 값을 받는다.
- 레이싱 횟수는 음수 값을 가질수 없다.

### Cars class
- Car Array 를 입력 값으로 받는다.
- play method 는 EnergyGenerator 를 인자로 받고 Car Array 크기 만큼 create 메소드를 호출한다.
- play method 에 잘못된 인자값인 경우 에러를 발생한다.
- winner method 는 우승한 Car Array 를 넘겨준다.
- winner 호출 시 car 정보들이 없으면 에러를 발생한다.