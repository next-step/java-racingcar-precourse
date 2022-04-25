# 자동차 경주 게임 구현

### 실행 환경
- JDK 8

### 제약사항 1
- 자동차 경주 게임을 실행하는 시작점은 src/main/java 폴더의 `racinggame.Application`의 `main()`이다.
- JDK 8버전에서 실행 가능 해야 한다.
   - 실행되지 않을 경우 0점처리 된다. 
- JDK에서 제공하는 Random 및 ScannerAPI 대신 `c`amp.nextstep.edu.missionutils`에서 제공하는 
`Randoms` 및 `ConsoleAPI`를 사용하여 구현한다.
    - Random값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java`폴더의 `racinggame.ApplicationTest`에 있는 2개의 TestCase가 성공해
야한다
    - 테스트가 실패할 경우 0점처리 한다.

### 제약사항 2

- [자바 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)을 지키며 프로그래밍 한다.
- 들여쓰기 깊이(indentation depth)는 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예시) while문 안의 if문 => depth 2 임
    - depth를 줄이는 좋은 방법은 메서드 분리이다.
- Java 8에 추가된 stream API를 사용하지 않는다. 단, 람다 함수는 허용한다.
- else 예약어를 쓰지 않는다.
  - switch/case 구문도 허용되지 않는다.
- 함수(또는 메서드) 길이가 10이 넘어가지 않도록 구현한다.


### 제약사항 3
- 도메인 로직에 단위테스트를 구현한다. UI 로직은 구현하지 않아도 된다.
    - 핵심로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다. 
- 일급 컬렉션을 활용해 구현한다.
- 모든 원시값과 문자열을 포장한다.

### 기능 요구사항
- [X] 각 자동차의 이름을 ","로 구분하여 경주할 자동차를 입력할 수 있다.
- [X] 자동차 이름은 5자 이하만 가능하다.
- [X] 자동차가 전진하는 조건은 0과 9 사이에서 random값을 구한 후, 4 이상일 경우 전진하고 3이하의 값이면 멈춘다.
- [X] 사용자에게 경주 회차를 입력받고 회차만큼 경주를 진행한다.
- [X] 각 회차마다 결과를 출력한다.
- [X] 경주게임 완료 후 우승자를 구한다.
- [X] 우승자를 화면에 출력한다. 여러명일 경우 쉼표로 구분해 출력한다.
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시킨다.
- [X] 자동차 이름 입력 시 에러가 발생하면, [ERROR]로 시작하는 메세지를 출력 후 그 부분부터 다시 입력받는다.
- [X] 시도할회수 입력 시 에러가 발생하면, [ERROR]로 시작하는 메세지를 출력 후 그 부분부터 다시 입력받는다.
- [X] 입력받는 문자열 공백 제거