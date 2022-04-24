# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 요구사항

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈
  춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
* 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
* Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 제약사항

* 자동차 경주 게임을 실행하는 시작점은 src/main/java 폴더의 racinggame.Application의 main()이다.
* 자동차 경주 게임은 JDK 8 버전에서 실행가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다. * JDK에서 제공하는 Random 및 Scanner API 대신
  camp.nextstep.edu.missionutils에서 제공하
  는 Randoms 및 Console API를 사용하여 구현해야 한다.
* Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
* 프로그램 구현을 완료했을 때 src/test/java 폴더의 racinggame.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
* ApplicationTest에서 제공하는 2개의 Test Case는 자동차 경주 게임을 위한 최소한의 Test Case이다.
* 필수 요구사항은 아니지만 제공하는 소스 코드를 참고해 자동차 경주 게임을 위한 모든 Test Case를 추가해 보는 것도 테스트에 대한 좋은 연습이 될 수 있다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
