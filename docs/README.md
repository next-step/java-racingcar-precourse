## 자동차 경주 게임

### 기능 요구사항

1. 주어진 횟수 동안 n 대의 자동차는 전진 또는 멈출 수 있다
1. 자동차마다 이름을 부여할 수 있으며, 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력해야 한다
1. 자동차의 이름은 `,` 를 기준으로 구분하며 5자 이하이어야 한다
1. 전진은 0~9 사이의 랜덤 값을 받고, 해당 값이 4 이상일 경우 전진하고 미만이면 멈춘다
1. 자동차 경주 게임을 완료한 후 우승자를 알려줘야 한다
    * 우승자가 여러명이면 `,` 로 이름을 구분해서 출력한다
1. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시키고 `[ERROR]` 로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다
    * `Exception` 이 아닌 `IllegalArgumentException`/`IllegalStateException` 등과 같은 명확한 유형을 처리해야 한다

### 게임 진행 예시

* 경주 할 자동차 이름을 `,` 을 기준으로 구분하여 입력받는다
* 시도할 횟수를 입력 받는다
* 해당 횟수만큼 각 자동차의 결과를 출력한다
* 모든 결과가 출력되면 최종 우승자를 `,` 로 구분하여 출력한다

### 제약사항

* 자동차 경주 게임은 JDK 8 버전에서 실행이 가능해야 한다
    * 터미널에 `java -version` 명령어를 통해 버전을 확인할 수 있다
* 자동차 경주 게임의 실행 시작점은 `src/main/java` 폴더의 `racinggame.Application` 의 `main()` 이다
* `src/test/java` 폴더의 `racinggame.ApplicationTest` 의 기본 2개의 Test Case 가 성공해야 한다
    * 제공되는 기본 2개 Test Case 는 필수이며, 추가적으로 작성하여도 된다
    * Mac, Linux 사용자의 경우 터미널에 `./gradlew clean test` 명령어를 통해 Test Case 를 실행할 수 있다
    * Window 사용자의 경우 터미널에 `gradlew.bat clean test` 명령어를 통해 Test Case 를 실행할 수 있다
* JDK 에서 제공하는 `Random`/`Scanner API` 대신 `camp.nextstep.edu.missionutils` 에서 제공하는 기능으로 구현해야 한다
    * Random 값 추출: `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()` 를 활용한다
    * 사용자 입력값 처리: `camp.nextstep.edu.missionutils.Console` 의 `readLine()` 을 활용한다
* [링크](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 의 자바 코드 컨벤션을 지켜야 한다
* indent depth 는 2가 넘지 않아야 한다
    * if, while 등의 block 안에 다시 다른 block 이 있을 경우 2 depth 이다
* [일급콜렉션](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)을 활용해서 구현한다
* [모든 원시값과 문자열을 포장한다](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)
* 메소드의 길이가 10 라인을 넘어가지 않아야 한다
* 도메인 로직에 단위 테스트를 구현해야 한다
    * UI 로직은 제외
* [링크](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 의 커밋 메시지 컨벤션을 참고하여 commit log 를 남겨야 한다
