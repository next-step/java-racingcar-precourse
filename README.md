# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

Racing Car
* 경주할 자동차 [RacingCar]
  * 자동차에 이름을 부여할 수 있다.
    * 5자 이상이면 IllegalArgumentException.
  * random 값이 4이상일 경우 전진, 3이하의 값이면 멈춘다.
    * 0~9사이의 값이 아니면 IllegalArgumentException.

* 난수 생성 [Generator]
  * 0에서 9사이에서 random 값 생성

* 경주할 자동차들 [RacingCars]
  * 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

* 사용자 [User]
  * 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    * 숫자만 입력을 받아야 한다. 다른 값이 들어오면 IllegalArgumentException.
  * 자동차 이름은 쉼표(,)를 기준으로 구분하며 입력한다.

* 우승자 [Winners]
  * 우승자를 가지고 있는다.

* 에러 문구
  * [ERROR]로 시작해야 한다.
  
---

## 요구사항
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* 들여쓰기 depth를 2가 넘지 않도록 구현한다.
* stream api 사용하지 않은다.
* else 사용하지 않는다
* 메서드의 길이가 10라인을 넘어가지 않도록 구현한다.
* 일급콜렉션을 확용해 구현한다.
* 모든 원시값과 문자열을 포장한다.
* 단위 테스트를 작성한다.
