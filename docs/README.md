## 2주차 미션 - 자동차 경주 게임

### 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 입출력 요구사항

- 입력
  - 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
    - pobi,woni,jun
  - 시도할 회수
    - 5
- 출력
  - 각 차수별 실행 결과
    - pobi : —— 
    - woni : --- 
    - jun : ---- 
  - 단독 우승자 안내 문구 
    - 최종 우승자: pobi
  - 공동 우승자 안내 문구
    - 최종 우승자: pobi, jun
  - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR]로 시작해야 한다. 
  <br>[ERROR] 시도 횟수는 숫자여야 한다

### 프로그래밍 요구사항
- 제약사항
  - JDK에서 제공하는 Random 및 Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console API`를 사용하여 구현해야 한다. 
  - 모든 원시값과 문자열을 포장한다.
    - 참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
  - 일급콜렉션을 활용해 구현한다.
    - 참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4
- 단위 테스트
  - 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외 