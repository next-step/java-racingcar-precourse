# java-racingcar-precourse

## 게임 설명

- 자바 레이싱카 게임 구현. 
입력을 받고, 일정 확률로 자동차를 전진시킴. 입력받은 횟수동안 반복 후 최종 승자를 가려냄.

### 객체

#### Model - RacingGameCar 

- 게임의 자동차 객체
- 이름, 현재 진행 상태를 나타냄.
- toString() overriding을 통해 객체의 상태 출력

#### View - RacingGameView

- 게임 진행 중, User와 상호 작용 담당. (출력)

#### View - RacingGameExceptionHandler 

- 게임 진행 중, User의 input을 받는 부분에서, 예외를 처리하는 클래스

#### Controller - ForwardLogic

- 랜덤한 난수를 생성 후, 조건에 맞게 forwarding하는 클래스

#### Controller - RacingGame

- 전반적인 게임의 logic을 담당하는 클래스
- 게임의 진행과, 끝(승자 판단)을 담당함.
