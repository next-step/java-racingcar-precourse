# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
    * 본인 repository에 소스코드 올려놓고 fork한 repository에 pr 올리기
* [우테캠 Pro 지원 플랫폼](https://apply.techcourse.co.kr/) 통해 과제 최종 제출

## 컨벤션
* [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
* [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
* 기능 단위로 commit

## 세 가지 요구사항
* 기능 요구사항(기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구성)
  1. n대의 차를 입력 받는다.
     * 쉼표 기준
     * 5자 이하만 가능 -> Car 클래스에서 validation
     * 입력 값 검증
       * IllegalArgumentException 등 명확한 유형으로 처리
       * 에러 메시지 출력
       * 다시 입력 받기
       * 종류
         * 최소 2대 이상 -> Cars 클래스에서 validation
         * 빈 값 x ("") -> Car 클래스에서 validation
  2. 몇 번을 시도할 것인지 입력받는다.
     * 입력 값 검증
       * IllegalArgumentException 등 명확한 유형으로 처리
       * 에러 메시지 출력
       * 다시 입력 받기
       * 종류
         * 숫자만 가능
  3. 전진 혹은 멈춤을 판단한다.
     1. 0-9 사이의 랜덤 값을 만든다.
     2. 4 이상이면 전진
     3. 3 이하의 값이면 멈춘다.
  4. 게임 완료한 후 누가 우승했는지 이름을 출력한다.
     * 우승자가 한 명 이상인 경우 쉼표로 구분하여 출력
* 프로그래밍 요구사항
    * JDK 8
    * 시작점은 src/main/java 폴더의 racinggame.Application의 `main()`
    * `Random` 및 `Scanner` API 대신 camp.nextstep.edu.missionutils에서 제공하는 `Randoms` 및 `Console` API를 사용
        * Random 값 추출은 Randoms의 `pickNumberInRange()` 활용
        * 사용자 입력 값은 Console의 `readLine()` 활용
    * 구현 완료 시 src/test/java 폴더의 racinggame.ApplicationTest에 있는 2개의 Test Case가 성공해야함
        * (Optional)제공하는 소스 코드 참고해 야구게임을 위한 모든 Test Case 추가해보기
    * [자바 코드 컨벤션](#컨벤션) 지키기
    * indent(들여쓰기) depth가 2를 넘지 않도록 한다. 1까지만 허용
        * while문 안에 if문 있으면 depth 2
        * (힌트) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리
    * stream api 사용하지 않고 구현. 람다는 사용 가능
    * else 예약어 쓰지 않기(당연히 switch/case도)
    * 함수(또는 메서드)의 길이가 10라인 넘어가지 않도록. 한 가지 일만 잘 수행하도록.
    * 일급콜렉션을 활용해 구현
    * 모든 원시값과 문자열을 포장
    * 도메인 로직에 단위 테스트 구현. 단 UI(System.out, System.in, Scanner) 로직은 제외
        * 핵심 로직을 구현하는 코드와 UI 담당 로직 분리
        * (힌트)MVC 패턴 기반 구현 후 View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집중
    * `학습테스트를 통해 JUnit 학습하기.pdf` 문서 참고
* 과제 진행 요구사항
    * 과제 레포지토리에서 fork/clone
    * `README.md`에 구현할 기능 목록 정리 추가하기
    * `README.md`에 정리한 기능 목록 단위 또는 의미있는 단위로 commit
        * [커밋 메시지 컨벤션](#컨벤션) 참고
    * 과제 제출 방법은 [과제-제출-과정](#과제-제출-과정) 참고
