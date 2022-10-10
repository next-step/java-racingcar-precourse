# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
- [x] 자동차는 0에서 9사이의 random 값을 가져와서, 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- [x] 각 자동차에 이름을 부여할 수 있다.
- [x] 자동차 이름은 5자이하만 가능하다.
- [x] 여러 대의 자동차는 주어진 횟수 동안 전진 또는 멈출 수 있다.
- [x] 여러 대의 자동차 이름을 쉼표로 구분하여 입력 받는다.
- [x] 사용자는 자동차의 이동 횟수를 입력할 수 있다.
- [x] 자동차 경주 게임의 각 차수별로 이동거리를 알 수 있다
- [x] 자동차 경주 게임을 완료한 후 누가 우승 했는지를 알려준다.
- [x] 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
외
## 프로그램 요구사항 1
- 자동차 경주 게임을 실행하는 시작점은 src/main/java 폴더의 racinggame.Application의 main()이다.
- 자동차 경주 게임은 JDK8 버전에서 실행가능해야 한다. JDK8에서 정상 동작하지 않을 경우 0점 처리한다.
- JDK에서 제공하는 Random 및 ScannerAPI 대신 `camp.nextstep.edu.missionutils` 에서 제공하는 Randoms 및 ConsoleAPI를 사용하여 구현해야 한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()` 를 활용한다.
- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console` 의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 폴더의 `racinggame.ApplicationTest` 에 있는 2개의 TestCase가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
- ApplicationTest에서 제공하는 2개의 TestCase는 자동차 경주 게임을 위한 최소한의 TestCase 이다.
- 필수 요구사항은 아니지만, 제공하는 소스코드를 참고해 자동차 경주 게임을 위한 모든 TestCase를 추가해보는 것도 테스트에 대한 좋은 연습이될 수 있다.

## 프로그램 요구사항 2
- 자바코드컨벤션을지키면서프로그래밍한다.(https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를 들어, while 문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 streamapi를 사용하지 않고 구현해야 한다. 단, 람다는사용가능하다.
- else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지말라고하니, switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한가지 일만 잘하도록 구현한다.

## 프로그램 요구사항 2 - 2주차 추가
- 일급콜렉션을 활용해 구현한다.
- 참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
- 모든 원시값과 문자열을 포장한다.
- 참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4

## 프로그램 요구사항 3
- 도메인 로직에 단위테스트를 구현해야 한다. 단, UI(System.out,System.in,Scanner) 로직은 제외
- 핵심로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- 힌트는 MVC 패턴기반으로 구현한후 View, Controller를 제외한 Model에 대한 단위테스트를 추가하는것에 집중한다.
- JUnit5와 AssertJ 사용 법에 익숙하지 않은 개발자는 첨부한 "학습테스트를통해JUnit학습하기.pdf"문서를 참고해 사용법을 학습한 후 JUnit5 기반 단위테스트를 구현한다.
