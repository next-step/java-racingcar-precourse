# [STEP-1] 카카오 테크 캠퍼스 미니과제 2번째 

## 자동차 경주 (Racing Car)


### 프로그래밍 요구 사항 1
- [ ] JDK 17 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 Application 의 main() 이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료시 System.exit() 를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.

### 프로그래밍 요구 사항 2
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍 한다. (들여쓰기는 '4 spaces' 로 한다)
- [ ] indent (들여쓰기) depth 를 3이 넘지 않도록 구현한다.
- [ ] 3항 연산자를 사용하지 않는다.
- [ ] 함수는 한가지 일만 하도록 최대한 작게 만든다.
- [ ] JUnit 5 와 AssertJ 를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

### 프로그래밍 요구 사항 3
- [ ] 함수의 길이가 15 라인을 넘어가지 않도록 구현한다.
- [ ] else 예약어를 사용하지 않는다.
- [ ] 도메인 로직에 단위 테스트를 구현해야 한다.(핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.)


### 기능 목록
- [ ] 주어진 횟수 동안 N대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 각 자동차에 이름을 부여할 수 있다.
- [ ] 자동차 이름은 쉼표를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [ ] 사용자는 몇 번의 이동을 할 것인지 입력한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지 알려준다. (우승자는 한 명 이상일 수 있다.)
- [ ] 우승자가 여러 명일 경우 쉼표를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 **IllegalArgumentException** 을 발생시키고, **ERROR** 로 시작하는 에러 메세지를 출력 후 그 부분부터 입력을 다시 받는다.  