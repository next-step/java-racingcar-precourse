# java-racingcar-precourse

## 구현기 목록
- build.gradle 에 정의된 group 명으로 패키지 생성 후 Application class 추가
- UI 클래스 구현 - stdin 으로 부터 차량이름입력 기능 구현
- UI 클래스 구현 - stdin 으로 부터 레이스 카운트 입력 기능 구현
- Car 클래스 구현 - 경주에 사용 할 Car 데이터 모델 구현
- Car 클래스 구현 - 레이스 가능 여부 확인 기능 구현
- Car 클래스 구현 - 레이스 진행상태 반환 기능 구현
- Car 클래스 구현 - 레이스 기능 구현
- UI 클래스 구현 - 레이스 실행(run) 기능 구현
- Application 클래스 구현 - main 함수 구현

## 과제 진행 요구 사항
- 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 READ.me에 정리한 기능 목록 단위로 추가한다.
- AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.


## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다 시 받는다.
- Exception 이 아닌 IllegalArgumentException , IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 실행결과
```text
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
5
실행 결과
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

pobi : ----- 
woni : ---- 
jun : -----

최종 우승자 : pobi, jun
```
