# 초기 클래스 설계
- RacingCars : RacingCar들의 집합 (*1급 콜렉션)
- RacingCar : 주요 필드 - 자동차 이름, 현재 위치
- RacingCarName : 자동차의 이름을 나타내는 작은 객체 (* 모든 원시값과 문자열을 포장)
- RacingCarPosition : 자동차의 위치를 나타내는 작은 객체 (* 모든 원시값과 문자열을 포장)
- 전략패턴을 이용해서 전진알고리즘을 캡슐화

- RacingCarGameView : UI 출력
  - printStageResult
  - printWinner
  - printError
  - takeRacingCarNames
  - takeTryCount

# 기능 목록
- [X] 자동차 전진
- [X] N대 자동차 전진
- [X] 게임 초기화
  - [X] 자동차 이름 입력 및 검증
  - [X] 시도회수 입력 및 검증
- [X] 게임 단계 진행
- [X] 우승자 선택

