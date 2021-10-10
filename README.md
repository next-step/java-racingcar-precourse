# 구현할 기능 목록
1. 게임의 한 턴이 진행되면 전진 혹은 멈추는 자동차를 구현한다.
  1) 자동차 역할을 하는 Car 클래스를 구현한다.
  1) Car 클래스의 전진 기능을 하는 forward() 함수를 구현하고, 멈춤 기능은 forward() 함수를 호출하지 않음으로써 달성한다.
  2) forward() 함수는 Car 클래스의 위치값을 1 증가시키고, 증가된 위치값을 리턴한다.
  3) 랜덤 값을 생성하여 Car 클래스의 forward() 함수에게 전달하는 RandomCarMover 클래스를 구현한다.
2. 게임의 턴을 여러번 진행하는 기능을 구현한다.
3. 게임의 모든 턴이 끝나고 최종 우승자를 선별하는 기능을 구현한다.
4. 사용자에게 게임에 참가할 플레이어들의 이름을 입력받는 기능을 구현한다.
5. 사용자에게 게임의 총 턴수를 입력받는 기능을 구현한다.
6. 게임의 한 턴이 끝날 때마다 게임의 진행 상황을 Console 창에 표시하는 기능을 구현한다.
7. 게임이 끝나고 최종 우승자들이 선별되면 Console 창에 표시하는 기능을 구현한다.
8. 사용자가 플레이어들의 이름을 잘못 입력한 경우 에러 메시지를 표시하고 재입력 받는 기능을 구현한다.
9. 사용자가 게임의 총 턴수를 잘못 입력한 경우 에러 메시지를 표시하고 재입력 받는 기능을 구현한다.

# 소프트웨어 품질 체크 사항

"소트웍스 앤솔러지"의 소프트웨어 품질 향상 9단계의 기준을 충족한다.
(참고문서: https://developerfarm.wordpress.com/2012/01/26/object_calisthenics_1/)

1. 한 메서드에 오직 한 단계의 들여쓰기만 한다. (참고문서: https://developerfarm.wordpress.com/2012/01/26/object_calisthenics_2/)
2. else 예약어(keyword)를 쓰지 않는다. (참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_3/)
3. 모든 원시값과 문자열을 포장(wrap)한다. (참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)
4. 한 줄에 점을 하나만 찍는다. (참고문서: https://developerfarm.wordpress.com/2012/01/30/object_calisthenics_5/)
5. 줄여쓰지 않는다(축약 금지). (참고문서: https://developerfarm.wordpress.com/2012/01/30/object_calisthenics_6/)
6. 모든 엔티티(entity)를 작게 유지한다. (참고문서: https://developerfarm.wordpress.com/2012/01/31/object_calisthenics_7/)
7. 2개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다. (참고문서: https://developerfarm.wordpress.com/2012/01/31/object_calisthenics_8/)
8. 제일 클래스(first-class) 콜렉션을 쓴다. (참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
9. 게터(getter)/세터(setter)/프로퍼티(property)를 쓰지 않는다. (참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_10/)


# 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 차종차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
* 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
* 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.


# 제약 사항
1. 
  * 자동차 경주 게임을 실행하는 시작점은 src/main/java 폴더의 racinggame.Application의 main()이다.
  * 자동차 경주 게임은 JDK 8 버전에서 실행가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다.
  * JDK에서 기본 제공하는 Random, Scanner API 대신 nextstep.utils 패키지에서 제공하는 Randoms, Console API를 활용해 구현해야 한다.
  * Random 값 추출은 nextstep.utils.Randoms의 pickNumberInRange()를 활용한다.
  * 사용자가 입력하는 값은 nextstep.utils.Console의 readLine()을 활용한다.
  * 프로그램 구현을 완료했을 때 src/test/java 폴더의 racinggame.ApplicationTest에 있는 2개의 Test Case가 성공해야한다.
  * ApplicationTest에서 제공하는 2개의 Test Case는 숫자 야구게임 구현을 위한 최소한의 Test Case이다.
  * 필수 요구사항은 아니지만 제공하는 소스 코드를 참고해 숫자 야구게임을 위한 모든 Test Case를 추가해 보는 것도 테스트에 대한 좋은 연습이 될 수 있다.

2.
  * 자바 코드 컨벤션을 지키면서 프로그래밍한다. (https://naver.github.io/hackday-conventions-java/)
  * indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
  * 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
  * else 예약어를 쓰지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  * 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

3.
  * 일급 콜렉션을 활용해 구현한다. (참고문서: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
  * 모든 원시값과 문자열을 포장한다. (참고문서: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)

4.
  * 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, SCanner) 로직은 제외
    * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    * 힌트는 MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 MOdel에 대한 단위 테스트를 추가하는 것에 집중한다.
    * JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해 사용법을 학습한 후 JUnit5 기반 단위 테스트를 구현한다.



# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
