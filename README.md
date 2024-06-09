# java-racingcar-precourse

# 객체별 기능 목록 

## 자동차 객체 Car class
- [x] String name 자동차 이름 저장하는 변수 
- [x] int state 현재까지 얼만큼 움직였는지 저장하는 변수
- [x] move() 움직일지 말지 결정하고 반영하는 메서드 
  * 0~9사이 무작위 값 구한후, 무작위 값이 4 이상일 경우 1칸 움직임 
  * 실행 결과를 자동차 객체 상태 state 변수에 반영
- [x] 자동차 객체의 이동 현황 출력

## 게임 진행 프로그램 Game class
- [x] getCarName() 자동차 이름 입력받기 기능
    - [x] 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    [x] 이상치 체크 후 이상한 값인 경우 입력을 다시 받도록함

[x] getTryNum() 시도 회수 입력받기 기능
    [x] 시도할 회수는 몇회인가요?
    [x] 이상치 체크 후 이상한 값인 경우 입력을 다시 받도록함 

[x] 자동차 객체를 생성 하는 기능

[x] findWinner() 경주 종료 후, 최종 우승자를 판별하는 기능 (여러명 일 수 있음)
[x] printWinner() 최종 우승자를 출력하는 기능 
    [x] 최종 우승자 :


## 이상치 판별 클래스 CheckInput class
[x] checkCarName(List<String> carNames)자동차 이름 이상 판별
    자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

[x] isWrongValue() 잘못된 값 입력시 에러발생 및 출력
    [x] IllegalArgumentException 를 발생시키고,
    [x] "[ERROR]"로 시작하는 에러 메시지를 출력 

## 게임 진행 클래스 Application class
[x] 사용자로부터 자동차 이름 입력받기
[x] 자동차 객체 생성하기  
[x] 사용자로부터 게임 회수 입력받기

[x] 회수만큼 게임 진행 
    [x] 자동차 객체별로 이동거리 관리 
    [x] 실행결과 출력 
[x] 최종 우승자 계산
[x] 최종 우승자 출력

## 참고 
[ ] 메서드 명은 동사로 시작
[ ] 메서드명 , 클래스 명이 모호하지 않도록 하기 


## 실행결과 예시 
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5
실행 결과
pobi :
woni :
jun :

pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

최종 우승자 : pobi, jun