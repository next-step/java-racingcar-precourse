# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 구현 내용

* RacingCarGameModel : 자동차 경주 게임에서 데이터 처리 부분을 담당하는 클래스

| Method                                                 | Description                                                                        |
|--------------------------------------------------------|------------------------------------------------------------------------------------|
| String generateWinner(HashMap<String, Integer> racers) | 매개변수 HashMap에서 우승자를 찾아내 문자열로 리턴하는 메서드, 우승자가 2명 이상인 경우 콤마(", ")로 구분                 |
| private void setCarUsers(String[] racerNames)          | 자동차 이름이 저장된 문자열 배열 매개변수를 racers HashMap 필드에 초기화 시키는 메서드                            |
| HashMap<String, Integer> run()                         | racers HashMap 필드 데이터를 바탕으로 Random 값에 따라, racers HashMap 필드의 position 값을 증가시키는 메서드 |

* RacingCarGameView : 자동차 경주 게임에서 사용자에게 보이는 View 부분을 담당하는 클래스

| Method                                                      | Description                                 |
|-------------------------------------------------------------|---------------------------------------------|
| void printWinner(String winners)                            | 매개변수로 전달받은 문자열로 최종 우승자를 출력하는 메서드            |
| private String makePosition(int runCount)                   | 매개변수로 전달받은 정숫값만큼 RUN_MARK(-)를 문자열을 리턴하는 메서드 |
| private void printPosition(HashMap<String, Integer> racers) | 전달받은 HashMap 매개변수를 바탕으로 자동차별 위치를 출력하는 메서드   |
| boolean validateCarName(String input)                       | 매개변수로 전달받은 문자열이 자동차 이름에 부합하는지 검증하는 메서드      |
| private int askTryCount()                                   | 사용자에게 경주 횟수를 묻는 콘솔 메시지를 표시하고, 입력 값을 받는 메서드  |
| private String[] askCarName()                               | 사용자에게 자동차 이름을 묻는 콘솔 메시지를 표시하고, 입력 값을 받는 메서드 |

* RacingCarGameController : 자동차 경주 게임에서 사용자에게 보이는 View와 데이터를 처리하는 Model을 연결하는 클래스

| Method               | Description         |
|----------------------|---------------------|
| private void start() | 자동차 경주 게임을 시작하는 메서드 |

* Utils : 자동차 경주 게임에서 사용하는 공통적인 메서드를 담당하는 클래스

| Method                                                      | Description                                                                                    |
|-------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| private static void checkDuplicateCarName(String[] carName) | 전달받은 문자열 배열에서 중복 값이 없는지 확인하는 메서드, 중복 값이 있는 경우 IllegalArgumentException 발생 후 에러 메시지 출력          |
| private static void checkCarNameLength(String[] carNames)   | 전달받은 문자열 배열의 값들이 1~5 범위의 값을 가지는지 확인하는 메서드, 범위를 벗어나는 경우 IllegalArgumentException 발생 후 에러 메시지 출력 |
| private static String[] isContainComma(String carNames)     | 전달받은 문자열에 콤마(",")가 포함되었는지 확인하는 메서드, 콤마(",")가 없는 경우 IllegalArgumentException 발생 후 에러 메시지 출력     |
| private static boolean isNumber(String input)               | 전달받은 문자열이 정수 형태로 파싱 가능한지 확인하는 메서드, 정수로 변환되지 않는 경우 NumberFormatException 발생 후 에러 메시지 출력         |
