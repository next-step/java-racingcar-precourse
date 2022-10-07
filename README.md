# 자동차 경주 게임

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

## 기능 목록

1. 사용자에게 자동차 이름을 입력 받는 다.
    - [x] 아래와 같이 입력 받는다.
        - 출력 예시) 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
        - pobi,crong,honux
    - [x] 자동차 이름은 5자 이하 까지 가능 하다.
    - [x] 여러 개의 자동차 이름을 입력 받는 경우 이름을 쉼표(,)로 구분 한다.
    - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시킨다.
        - [x] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
        - [x] [ERROR]로 시작하는 에러 메시지를 출력 한다.
            - 출력 예시) [ERROR] 자동차 이름은 5자 이하 까지 가능 하다.
    - [x] 에러가 발생한 그 부분부터 입력을 다시 받는다.
2. 사용자에게 경주 시도 횟수, 이하 게임 회차를 입력 받는 다.
    - [x] 아래와 같이 입력 받는다.
        - 출력 예시) 시도할 횟수는 몇회인가요?
            - 5
    - [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시킨다.
        - [x] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
        - [x] [ERROR]로 시작하는 에러 메시지를 출력 한다.
            - 출력 예시) [ERROR] 시도 횟수는 숫자여야 한다.
    - [x] 에러가 발생한 그 부분부터 입력을 다시 받는다.
3. 자동차 기능 구현
    - [x] 사용자에게 입력 받은 자동차 이름 수 만큼 자동차를 생성한다.
    - [x] 사용자가 입력한 게임 회차만큼 자동차들이 경주한다.
    - [x] 자동차는 경주하면서, 전진하거나 멈출 수 있다.
    - [x] 자동차는 게임 회차별 경주 상태를 가지고 있다.
    - [x] 자동차가 전진하면 경주 상태에 -이 추가 된다.
        - 예) 1회차에 전진시 경주 상태는 -이 된다.
    - [x] 자동차가 멈추면 경주 상태는 추가 되지 않는다.
        - 예) 1회차에 전진, 2회차에 멈추면 상태는 -이 된다.
4. 경주 기능 구현
    - [x] 게임 회차가 시작될 때마다, 자동차 별로 0에서 9까지 랜덤 값을 구한다.
        - [x] 랜덤값이 4 이상이면 자동차가 전진 한다.
        - [x] 랜덤값이 3 이하면 멈춘다.
    - [x] 게임 회차가 종료될 떄마다, 자동차 별 경주 진행 상태를 출력 한다.
        - 출력 예시) 실행 결과  
          자동차이름 : 경주 상태 -> honux : -
5. 게임 결과 출력
    - [x] 게임을 완료한 후 누가 우승했는 지 알려준다.
        - [x] 우승자가 한 명인 경우 아래와 같이 출력한다.
            - 출력 예시) 최종 우승자 : 자동차이름
        - [x] 우승자가 한 명이상인 경우 쉼표(,)로 이름을 구분해 출력한다.
            - 출력 예시) 최종 우승자 : 자동차이름, 자동차이름

## 프로그래밍 요구사항

1. [x] racinggame.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
2. [x] 도메인 로직에 단위 테스트를 구현해야 한다.
3. [x] indent(인덴트, 들여쓰기) depth 1까지 허용 한다.
4. [x] 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
5. [x] else 예약어를 쓰지 않는다.
6. [x] 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
7. [x] 일급콜렉션을 활용해 구현한다.
8. [x] 모든 원시값과 문자열을 포장한다.

## 제약 사항

1. [x] JDK 8 버전 사용
2. [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
3. [x] 코드컨벤션 : https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
