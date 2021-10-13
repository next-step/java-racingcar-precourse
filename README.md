# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 요구사항
* ### 기능 요구사항
  * [X] 주어진 횟수동안 전진 또는 멈출 수 있다.
  * [X] 각 자동차에 이름을 부여하며, 전진을 출력시 자동차이름을 같이 출력한다.   
  * [X] 자동차 이름은 쉼표로 구분하고 5자이하로만 가능하게 구현한다.
  * [X] 몇 회를 이동할지 사용자가 입력할수 있어야한다.
  * [X] 0~9의 랜덤값을 구한 뒤 4이상일경우에만 전진한다.
  * [X] 경기가 끝나면 누가 우승했는지 출력한다 (다수 가능)
  * [X] 사용자가 잘못된 값을 입력하면 [ERROR] 로 시작하는 에러메시지를 출력 하고 다시 입력을 받는다.

* ### 프로그램 제약사항
  * [X] 시작점은 src/main/java/racinggame.Application의 main() 이다.
  * [X] JDK 8에서 실행가능하여야한다.
  * [X] Random과 Input은 nextstep.utils에서 제공하는 모듈을 사용한다.
    * Randoms의 pickNumberInRange()를 사용
    * Console의 readLine()을 사용
  * [X] src/test/java/racinggame.ApplicationTest에 있는 Testcase 두개가 성공해야된다.

* ### 컨벤션
  * [X] 자바 코드 컨벤션을 지키면서한다.
  * [X] indent depth는 1을 넘기지 않는다.
  * [X] 자바 8의 stream api를 사용하지않는다.
  * [X] else를 사용하지 않는다.
  * [X] 함수의 길이가 10라인을 넘어가지않는다.

* ### 요구사항 2주차 추가
  * [X] 일급콜렉션을 활용해 구현한다.
  * [X] 모든 원시값과 문자열을 포장한다.
  * [X] 도메인 로직에 단위 테스트를 구현한다.