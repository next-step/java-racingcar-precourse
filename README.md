# 프리코스 2주차: 자동차 경주 게임

메일을 통해 받은 `프리코스_2주차_자동차경주게임.pdf`을 참고하여 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항을 도출하였다.

## 기능 요구사항

- 사용자로부터 자동차 이름 및 라운드를 입력받는 기능

    - 쉼표를 기준으로 자동차 이름 구분
    - 자동차 경주를 위해 최소 2대의 자동차 생성
    - 자동차가 1대일 경우 재입력 요청
    - 자동차 이름이 5글자 이하가 아닌 경우 재입력 요청
    - 라운드는 숫자가 아닌 다른 문자가 입력될 경우 재입력 요청

- 자동차가 전진하거나 멈춰있는 기능

    - 임의의 수가 4 이상일 경우 전진
    - 임의의 수가 3 이하일 경우 멈춤

- 경주 완료 후 결과를 발표하는 기능

    - 우승자가 두 명 이상일 경우, 쉼표로 구분하여 출력

- 사용자가 잘못된 값을 입력할 경우 `[ERROR]`로 시작하는 메시지를 출력하는 기능

## 프로그래밍 요구사항

- 자동차 경주 게임을 실행하는 시작점은 `src/main/java` 폴더에 위치한 `racinggame.Application`의 main()이다.
- JDK 8 버전에서 실행가능해야 한다.
- JDK에서 기본으로 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 Randoms, Console API를 활용하여 구현한다.
- `src/test/java` 폴더에 위치한 `racinggame.ApplicationTest`에 구현되어 있는 2개의 Test Case를 통과해야 한다.
- [**Java 컨벤션**](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 을 지키며 프로그래밍한다.
- indent의 depth는 2이상을 허용하지 않는다.
- Stream API는 사용하지 않고 자동차 경주 게임을 구현한다. 단, 람다식은 사용할 수 있다.
- `else`, `switch/case` 를 사용하지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 도메인 로직에 해당되는 단위 테스트를 구현한다.
- 일급콜렉션을 활용해 구현한다.
- 모든 원시값과 문자열을 포장한다.

## 과제 진행 요구사항

- [**java-racingcar-precourese 저장소**](https://github.com/next-step/java-racingcar-precourse) 를 fork / clone 한 후에 과제를
  진행한다.
- `README.md` 파일에 자동차 경주 게임 기능 요구사항을 정리한다.
- 도출한 기능 요구사항 또는 의미있는 단위로 Commit한다.
- [**AngularJS Git Commit Message Conventions**](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 을 지키며
  Commit 내용을 작성한다.
- [**프리코스 과제 제출 문서**](https://github.com/next-step/nextstep-docs/tree/master/precourse) 를 참고하여 결과물을 제출한다.
