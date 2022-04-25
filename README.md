# 자동차 경주 게임  
## 진행 방법  
* 자동차 경주 게임 요구사항을 파악한다.  
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.  
  
## 과제 제출 과정  
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)  

## 기능 정의  
1. 요구사항  
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.  
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.  
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.  
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.  
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.  
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.  
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.  
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.  
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.  
  
2. 기능 목록  
[x] 경주할 자동차 이름을 입력받는다.  
- [x] 자동차 이름에 대한 예외처리  
- [x] 자동차 이름 조회  
[x] 레이싱을 시작한다.  
- [x] 랜덤숫자 생성  
- [x] 생성된 랜덤숫자에 따라 전진/정지  
[x] 최종 우승자 출력  
- [x] 우승자가 여러명일 경우 쉼표로 구분  
  
3. 리팩토링 목록  
[x] Controller, Service 로직 분리  
[x] Service를 InputService, GameService, ResultService 로 분리  
[x] final 변수 사용  
[x] [자바 코드 컨벤션](https://google.github.io/styleguide/javaguide.html#s3.4.1-one-top-level-class) 체크  
  
4. 테스트 목록  
[x] CarsTest  
- [x] 자동차이름 입력후 사이즈 검증  
- [x] 자동차이름 2개미만 입력시 예외 확인  
- [x] 자동차이름으로 5글자 이상 입력시 예외 확인  
[x] NameTest  
- [x] 자동차이름 입력하지 않았을 경우 예외  
- [x] 자동차이름 5글자 이상 입력시 예외 확인  
[x] PositionTest  
- [x] 포지션 검증  
- [x] 포지션 음수의 경우 예외  
- [x] 포지션 이동 테스트  
[x] RandomNumberTest  
- [x] 랜덤숫자가 4 미만일 경우 자동차 이동에 대한 boolean 값이 false 임을 확인  
- [x] 랜덤숫자가 4 이상일 경우 자동차 이동에 대한 boolean 값이 true 임을 확인  
[x] RoundTest  
- [x] 실행횟수 정상적으로 입력할 경우 해당 횟수가 제대로 저장되었는지 확인  
- [x] 실행횟수로 0이 입력되었을 경우 예외 확인  
- [x] 실행횟수로 음수가 입력되었을 경우 예외 확인  
[x] OutputTest  
- [x] 실행결과 출력 테스트  
- [x] 최종우승자 1명인 경우 출력 테스트  
- [x] 최종우승자 2명인 경우 출력 테스트  
