## Task별 요구사항 정리
### 1. 경기 정보 입력
- 경주할 자동차 입력
  - 경주할 자동차 입력 요청(view)
  - 경주할 자동차 입력(Console.readLine)
  - 자동차이름 유효성 체크 & 자동차 리스트 or 배열로 변환
    - 자동차 이름은 쉽표(,)를 기준으로 구분하며 5자 이하만 가능
    - 자동차 이름 중복 제한
    - 자동차 이름 1개 이상 입력
- 시도할 회수 입력
  - 회수 유효성 체크 
    - 숫자 아닌 모든 문자 입력 제한(Integer 파싱으로 오류확인)

### 2. 경기 실행
- 각 자동차별 랜덤수를 구하여 각 전진성적 추출
  - 전진하는 조건은 0-9 상이에서 random 값을 구한 후 random 값이 4 이상일 경우 전지, 3이하면 멈춘다

### 3. 경기 종료 & 우승자 선별
- 우승자 선발
  - 우승자 출력(view)

### 4. 예외상황 처리 
- 입력시 예외상황 IllegalArgumentException 처리 (에러 문구 [ERROR] 포함)
- 입력 오류 발생시, 해당 스테이지에서 재입력 받도록 처리


## 프로그래밍 제약사항
- JDK8, Application.main() 시작 
- 값추출 : camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()
- 사용자 입력 : camp.nextstep.edu.missionutils.Console.readLine() 
- [일급콜렉션 활용](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
- [모든 워시값과 문자열을 포장한다.](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4)
- 도메인 로직에 단위 테스트를 구현해야 한다
  - *MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집
    중한다.*
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

## 기능요구사항
- 주어진 횟수 동안 n대의 자동자 전진(GO)/STOP
- 각 자동차 이름을 부여 할 수 있다. 전진하는 자동차 출력할때 자동차 이름을 같이 출력
- 자동차 이름은 쉽표(,)를 기준으로 구분하며 5자 이하만 가능
- 사용자는 몇번의 이동을 할 것인지를 입력
- 전진하는 조건은 0-9 상이에서 random 값을 구한 후 random 값이 4 이상일 경우 전지, 3이하면 멈춘다
- 자동차 경주 게임을 완료한 후 누가 우승했는지 알려준다.
- 우승자가 1명 이상일 경우, 쉽표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 *그부분부터 다시 입력받는다.*
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

입력
- 자동자 이름 ex) pobi, woni, jun
- 시도할 회수 ex) 5

출력
- 각 차수별 실행 결과
  ex) pobi : -----
  woni : ---
  jun : ----
- 단독 우승자 안내 문구
  ex) 최종 우승자: pobi
- 공동 우승자 안내 문구
  ex) 최종 우승자: pobi, jun
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR]로 시작해야 한다.
  ex) [ERROR] 시도 횟수는 숫자여야 한다. 