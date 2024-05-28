# java-racingcar-precourse
## 구현할 기능
### Model
- **GameModel**
    - `int totalMove` 이동 횟수
    - `LinkedHashMap<String, Integer> carDistances` { 차 이름 : 주행 거리 }로 구성된 LinkedHashMap
    - `initGameModel()` 차량 개수, 이동 횟수로 게임 초기값 세팅
    - `updateCarDistances()` 차량별 주행 거리 갱신
    - `getWinnerList()` 우승한 차량 이름 리스트로 반환
    - `getCarDistances()` 차량별 주행거리 LinkedHashMap 반환
    - `getTotalMove()` 이동 횟수 반환
### View
- **GameView**
    - `getCarNamesInput()` 사용자로부터 차 이름값 입력
    - `getTotalMoveInput()` 사용자로부터 이동 횟수 입력
    - `displayCarDistances()` 전체 경주판 출력
        - `displayOneDistance()` 차 하나 이동거리 출력
    - `displayWinner()` 우승자 출력
    - `displayRaceStart()` 실행 결과 메시지 출력
### Controller
- **Validator**
    - `validateCarNames()` 차량 이름 입력 검사
    - `validateTotalMove()` 이동 횟수 입력 검사
    - `checkBlank()` 공백 검사
    - `containsBlank()` 공백 포함 검사
    - `checkNoCarName()` 잘못된 입력(,만 입력) 검사
    - `checkCarNameLengthOver()` 차량 이름 길이 검사
    - `checkDuplicatedCarName()` 차량 이름 중복 검사
    - `checkNotNumber()` 이동 횟수 정수값 검사
    - `checkUnderZero()` 이동 횟수 1이상 검사
- **GameController**
    - `GameController()` 생성자
    - `play()` 게임 전체 흐름 제어
    - `race()` 경주(이동) 시작
    - `showWinner()` 우승자 선별
    - `readCarNames()` 차량 이름 읽어오기(validation 포함)
    - `readTotalMove()` 이동 횟수 읽어오기(validation 포함)
### Util
- **Util**
  - `randomDistance()` 차가 이동할 거리(0 또는 1) 랜덤 반환
  - `getMaxDistance()` 차량들 중 최장 주행 거리 반환