# java-racingcar-precourse

## 개요
- 간단한 자동차 경주 게임을 구현한다.

## 기능 요구 사항

### 사용자
- 자동차의 이름, 시행 횟수를 입력한다.
### Application
- 프로그램의 엔트리 포인트

### InputView
- 사용자로 부터 자동차의 이름들, 시행 횟수를 입력 받는다.
- 예외 값 입력시 이후 "[ERROR]"로 시작하는 메세지 출력 후 입력을 다시 받는다.
  - 입력 받은 자동차 이름들을 List로 반환
    - 이름이 5자 초과인 경우 IllegalArgumentException 
  - 시행 횟수를 int 형으로 반환
    - 시행횟수가 Numberic이 아닌 경우 IllegalArgumentException

### OutputView
- 시행 횟수마다 경주의 결과를 출력
- 최종 우승자를 출력
  - 우승자는 1명 이상
  - 여러 명 일 경우 쉼표(,)로 구분

### RandomNumberGenerator
- 0~9 까지의 무작위 값을 생성
  - int 형으로 반환

### GameController
- 전제척인 흐름제어
- InputView로 부터 입력
- 시행횟수동안 carRace 시행
- 경주의 결과를 OutputView를 통해 출력

### Car
- 자동차 객체 (VO)
  - 자동차의 이름 String
  - 자동차의 현재 위치 int

### CarRace
- 자동차 객체들을 List로 관리
- 자동차들을 한번 경주 시킴
  - RandomNumberGenerator에 의해 0~9까지의 랜덤값을 받음
  - 자동차는 전진(+1) or 정지(0)
    - 전진 : 랜덤값 >= 4
    - 정지 : 랜덤값 < 4
 
## 프로그래밍 요구 사항
- JDK-17
- 엔트리 포인트는 Application의 main()
- build.gradle 변경 금지
- System.exit() 사용 금지
- else 및 switch 금지
- 도메인 로직에 단위 테스트 구현 (UI 제외)
  - 핵심 로직과 UI를 분리
  - MVC 패턴으로 View, Controller 분리 후 Model에 집중
