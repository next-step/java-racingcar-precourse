# java-racingcar-precourse

# MODEL
1. 클래스 이름 : Car
2. 멤버 변수 : String CarName, int ForwardStep
3. 멤버 함수 : 
   1. public Car(String carName, int forwardStep) : 자동차 이름(carName)과 초기 전진 단계(forwardStep)를 설정합니다.
      자동차 이름이 5자를 초과하면 IllegalArgumentException 예외를 발생시킵니다.
   2. public void SetCarName(String carName) : 자동차의 이름을 설정합니다.
      자동차 이름이 5자를 초과하면 IllegalArgumentException 예외를 발생시킵니다.
   3. public String GetCarName() : 자동차의 이름을 반환합니다.
   4. public void SetForwardStep(int goStep) : 자동차의 전진 단계를 설정합니다.
   5. public int GetForwardStep() : 자동차의 전진 단계를 반환합니다.
   6. 

---
# VIEW
1. 클래스 이름 : CarView
2. 멤버 함수 : 
    1. public void Print_CarNameAndForwardStep(Car c) : 입력으로 받은 자동차 객체의 이름과 현재 전진 단계를 출력합니다.
       전진 단계만큼 "-" 문자를 반복하여 표시합니다.
   2. public void printWinners(List<Car> winners) : 입력으로 받은 우승자 목록을 출력합니다.
      각 우승자의 자동차 이름을 출력합니다.

---
# CarRepository
1. 클래스 이름 : CarRepository
2. 멤버 변수 : List cars 
3. 멤버 함수 : 
   1. public void AddCar(String cn, int fs) : 입력된 자동차 이름(cn)과 초기 전진 단계(fs)로 새로운 자동차 객체를 생성하여 자동차 목록에 추가합니다.
   2. public List<Car> GetAllCar() : 저장된 모든 자동차 객체의 목록을 반환합니다.
   3. public Car GetCar(String cn) : 주어진 자동차 이름(cn)과 일치하는 자동차 객체를 반환합니다.
      자동차를 찾지 못한 경우 null을 반환합니다.

---
# CONTROLL
1. 클래스 이름 : CarController
2. 멤버 변수 : CarRepository model, CarView view
3. 멤버 함수 :
    1. public CarController(CarRepository model, CarView view) : 모델과 뷰 객체를 초기화합니다.
    2. public void AddCar(String cn, int fs) : 자동차 이름(cn)과 초기 전진 단계(fs)를 모델에 추가합니다
    3. public void AddCars(String carNamesInput) : 콤마로 구분된 여러 자동차 이름을 입력받아 각각의 자동차를 모델에 추가합니다.
       자동차 이름이 5자 이하인지 확인하고, 그렇지 않으면 예외를 발생시킵니다.
    4. public void Print_AllCnAndFs() : 모델에 저장된 모든 자동차의 이름과 전진 단계를 출력합니다.
    5. public void Trial() : 모든 자동차에 대해 무작위로 전진 단계를 증가시키고, 그 결과를 출력합니다.
    6. public void GenerateRandomStep(Car c) : 자동차 객체(Car)에 대해 0에서 9 사이의 랜덤 숫자를 생성하고, 이 숫자가 4 이상이면 전진 단계를 1 증가시킵니다.
    7. public boolean DecisionGo(int randNumber) : 랜덤 숫자가 4 이상이면 true를 반환하고, 그렇지 않으면 false를 반환합니다.
    8. public void printWinners() : 가장 많이 전진한 자동차를 찾아서 승자를 출력합니다.