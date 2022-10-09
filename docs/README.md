## 개발할 기능 목록
1. 조건에 맞는 자동차 이름과 시도할 횟수 입력 받기
2. 레이싱 경주 기능(랜덤 숫자를 통한이동)과 결과 저장 기능
3. 레이싱 경주 반복을 통해 우승자 찾기, 결과 출력

## 기능 요구사항
 * 주어진 횟수동안 n대의 자동차는 전진 또는 멈출수있다.
 * 각 자동차에 이름을 부여할 수 있다.전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자이하만 가능하다.
 * 사용자는 몇번의 이동을 할것인지를 입력할 수 있어야한다.
 * 전진하는 조건은 0 에서 9 사이에서 random 값을 구한 후 random 값이 4이상 일 경우 전진하고, 3 이하의 값이면 멈춘다.
 * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
 * 우승자가 한명 이상 일 경우, 쉼표(,)로 이름을 구분해 출력한다.
 * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러메시지를 출력 후 그부분부터 입력을 다시받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException등 과 같은 명확한 유형을 처리한다.

## 기능 개발 시 참조
- 자동차 경주 게임을 실행하는 시작점은 src/main/java 폴더의 racinggame.Application의 main()이다.
- 자동차 경주 게임은 JDK 8 버전에서 실행가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다.
- JDK에서 제공하는 Random 및 Scanner API 대신, camp.nextstep.edu.missionutils 사용
    - Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- 프로그램 구현을 완료했을 때 src/test/java 폴더의 racinggame.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
- 자바 코드 컨벤션 지키며 코딩.
- 테스트가 실패할 경우 0점 처리한다.
- 자바8 stream api 사용하지 않기
- else 예약어 쓰지 않기
- 함수 길이가 10라인 넘지 않도록 하기
- indent depth는 2가 되지 않도록
- 도메인 로직에 단위 테스트 구현
- 일급콜렉션 활용하기 및 모든 원시값과 문자열 포장하기
- [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)