### 프리코스 2주차 미션
> 미션은 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항으로 구성되어 있다.  
> 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만든다.  
> 기능 요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

### 1. 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다.
- 전진하는 자동차의 이름을 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 0-9 사이에 임의의 값이 4 이상일 경우 전진, 3 이하일 경우 멈춘다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 다음과 같이 처리한다.
  - Exception을 발생시키고 "[ERROR]"로 시작하는 에러 메시지를 출력한다.
  - 프로그램이 종료되지 않고 다시 입력값을 받을 수 있어야 한다.
  - Exception 보다는 상황에 맞는 하위 Exception 클래스를 찾아서 사용한다. 

### 2. 입출력 요구사항
입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
  - pobi,woni,jun
- 시도할 횟수
  - 5

출력
- 각 차수별 실행 결과
  - pobi : -----
  - woni : ---
  - jun : ----
- 단독 우승자 안내 문구
  - 최종 우승자: pobi
- 공동 우승자 안내 문구
  - 최종 우승자: pobi, jun
- 예외 상황 시 에러 문구를 출력해야 한다.
  - "[ERROR] 시도 횟수는 숫자여야 한다."

### 3. 프로그램 실행 결과 예시
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 횟수는 몇회인가요?
5

실행 결과
pobi : -
crong :
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

최종 우승자: pobi, honux
```

### 4. 프로그래밍 요구사항
- 자동차 경주 게임은 src/main/java 폴더의 racinggame.Application의 main() 메서드에서 시작한다.
- 자동차 경주 게임은 JDK 8 버전에서 실행가능해야 한다.
- camp.nextstep.edu.missionutils에서 제공하는 API를 사용하여 구현해야 한다.
  - Random 값 추출은 Randoms의 pickNumberInRange() 메서드를 사용한다.
  - 사용자가 입력하는 값은 Console의 readLine() 메서드를 사용한다.
- src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - [우아한테크코스의 자바 스타일 가이드](https://github.com/woowacourse/woowacourse-docs/blob/feature/styleguide/styleguide/java/README.md)
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다.
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 일급 컬렉션을 활용한다.
  - [더 나은 소프트웨어를 향한 9단계: 객체지향 생활 체조](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
- 모든 원시값과 문자열을 포장한다.
  - [더 나은 소프트웨어를 향한 9단계: 객체지향 생활 체조](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)
- 도메인 로직에 단위 테스트를 구현해야 한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- JUnit5 기반 단위 테스트를 구현한다.

### 5. 과제 진행 요구사항
- 미션은 [자동차 경주 게임 저장소](https://github.com/next-step/java-racingcar-precourse) 를 fork/clone해 시작한다.
- 기능을 구현하기 전에 docs/README.md 파일에 구현할 기능 목록을 정리해 추가한다.
- 깃은 docs/README.md 파일에 정리한 기능 목록 단위 또는 의미있는 단위로 커밋한다.
  - 커밋 메시지 컨벤션 참고해 커밋 로그를 남기려고 노력해 본다.
- 과제 진행 및 제출 방법은 프리코스 과제 제출 문서를 참고한다.

### 6. 과제 제출 전 체크리스트
- 자바 8인지 확인한다.
  - 터미널에서 "java -version" 또는 Eclipse, Intellij와 같은 IDE의 자바 8로 실행하는지 확인한다.
- 모든 테스트가 통과하는지 확인한다.
  - Mac 또는 Linux 사용자의 경우 ".gradle clean test" 명령을 사용한다.
  - Windows 사용자의 경우 "gradlew.bat clean test" 명령을 사용한다.


### 7. 미션 마감 및 기준
- 2022년 4월 25일(월) 23시 59분까지 GitHub와 구글 폼을 통해 제출한다.
- 2022년 4월 26일(화) 00시 이후 제출한 경우 미션을 제출하지 않은 것으로 한다.
