# 요구사항 정리

---

## 진행 방식

---

- 미션은 세 가지로 구성되어 있다.
    - 기능 요구사항
    - 프로그래밍 요구사항
    - 과제 진행 요구사항
- **기능을 구현하기 전에 기능 목록을 만들고**,
- **기능 단위로 commit**

## 과제 진행 요구사항

- [x] https://github.com/next-step/java-racingcar-precourse fork/clone
- [x] 기능을 구현하기 전에 **docs/README.md** 파일에 구현할 임기능 목록을 정리해 추가한다.
- [x] git의 commit 단위는 앞 단계에서 docs/README.md 파일에 정리한 **기능 목록 단위** 또는 **의미있는 단위**로 Commit
- [x] [커밋 메시지 컨벤션][커밋 메시지 컨벤션 URL] 참고해 commit log를 남기려고 노력해 본다.
- [x] 제 진행 및 제출 방법은 [프리코스 과제 제출 문서][프리코스 과제 제출 문서 URL]를 참고

## 과제 제출 전 체크리스트 - 0점 방지

- [x] 터미널에서 “java -version”을 실행해 자바 8인지 확인
- [x] 또는 Eclipse, Intellij와 같 은 IDE의 자바 8로 실행하는지 확인
- [x] ```./gradlew clean test``` 명령어를 실행하고, 모든 테스트가 통과하는지 확인


## 프로그래밍 요구사항

---

### 프로그래밍 요구사항1 - 제약사항
- [x] 자동차 경주 게임게임을 실행하는 시작점은 **src/main/java** 폴더의 **racinggame.Application**의 **main()** 이다
- [x] 자동차 경주 게임게임은 JDK 8 버전에서 실행가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다.
- [x] Random 및 Scanner 사용시 => camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
    - Random 값 추출은 **camp.nextstep.edu.missionutils.Randoms**의 **pickNumberInRange()**
    - 사용자가 입력하는 값은 **camp.nextstep.edu.missionutils.Console**의 **readLine()** 을
- [x] 완료시 src/test/java 폴더의 racinggame.ApplicationTest의 2개의 Test Case가 성공. 실패할 경우 0점
    - ApplicationTest에서 제공하는 2개의 Test Case는 자동차 경주 게임게임 구현을 위한 최소한의 Test Case이다.
    - [옵션] 소스 코드를 참고해 자동차 경주 게임게임을 위한 모든 Test Case를 추가해 보는 것도 테스트에 대한 좋은 연습.

### 프로그래밍 요구사항2 - 제약사항
- [x] [자바 코드 컨벤션][자바 코드 컨벤션 URL]을 지키면서 프로그래밍
    - [x] intellij-java-wooteco-style.xml 로 formatter 적용.
- [x] indent 1까지만 허용
    - ex) while문 안에 if문이 있으면 들여쓰기는 2
    - 힌트: ndent depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- [x] 자바 8에 추가된 **stream api를 사용하지 않고** 구현해야 한다. 단, **람다는 사용 가능**하다.
- [x] **else 예약어를 쓰지 않는다**.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다
    - switch/case도 허용하지 않는다
- [x] 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현

- [x] 일급콜렉션을 활용해 구현한다. [참고][일급콜렉션을 활용 URL]
  - [x] 콜렉션을 포함한 클래스는 반드시 다른 멤버 변수가 없어야 한다.
- [x] 모든 원시값과 문자열을 포장한다.[참고][모든 원시값과 문자열을 포장 URL]

### 프로그래밍 요구사항3 - 단위 테스트
- [x] 도메인 로직에 단위 테스트를 구현해야 한다
    - 단, UI(System.out, System.in, Scanner) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현
    - 힌트: **MVC 패턴 기반으로 구현한** 후 **View, Controller 를 제외한 Model 에 대한 단위 테스트를 추가**하는 것에 집중
- [x] JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한 "학습테스트를 통해 JUnit 학습하기.pdf" 문서를 참고해
  사용법을 학습한 후 JUnit5 기반 단위 테스트를 구현


## 기능 요구 사항

---

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 각 자동차에 이름을 부여할 수 있다. 
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
- [x] 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [x] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

### 입출력 요구사항
```shell
입력
• 경주할자동차이름(이름은쉼표(,)기준으로구분) 
pobi,woni,jun
• 시도할회수 5

출력
• 각차수별실행결과
pobi : --- 
woni : --- 
jun : ----
• 단독우승자안내문구 
최종 우승자: pobi
• 공동우승자안내문구 
최종 우승자: pobi, jun
• 예외 상황시 에러 문구를 출력해야한다. 단,에러문구는 [ERROR]로 시작해야 한다.
[ERROR] 시도 횟수는 숫자여야 한다.
```


### 프로그램 실행 결과
```shell

경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
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


### 기능 목록 정리

#### RacingGame (Controller)
- [x] 입력 받는다
  - [x] 이름 입력
    - [x] 사용자로 부터 입력받은 이름은 쉼표로 구분한다
    - [x] 5자 이하만 입력 가능하도록 한다
  - [x] 횟수 입력
    - [x] 양수값을 검증한다
- [x] 출력 한다
  - [x] 입력 안내 멘트
  - [x] 실행 결과 표시
- [x] 게임 횟수 만큼 진행한다.

####  (View)
- [x] 위치 표시
  - [x] 차의 이름과, 해당 위치만큼 - 로 표시한다.
- [x] 에러 메세지는 [ERROR] 로 시작한다.

#### CarRegister(domain)
- [x] 입력받은 이름으로 차량 이름을 배열을 생성한다.

#### RaceTrack (domain)
- [x] 생성된 이름들의 배열로 차량을 준비시킨다.
- [x] 총 시도회수(Lap)를 등록한다.
- [x] Lap을 돈다.

#### FinishLine (domain)
- [x] 자동차들 중 가장 큰 위치 값을 뽑아낸다
- [x] 최대 위치에 해당하는 자동차 객체들을 구한다.

#### Position (domain)
- [x] 위치값을 나타낼 수 있다.
- [x] 위치값을 증가한다.

#### Lap (domain)
- [x] 게임 진행 횟수 생성
  - [x] 0 에서 9 사이 random 값을 가진다.
- [x] Lap을 한바퀴 돌면 횟수를 차감한다.
- [x] Lap이 남았는지 판단한다.

#### Car (domain)
- [x] 이름을 가질 수 있다. 
- [x] 위치를 가질 수 있다.
- [x] 이동 할 수 있다.
  - [x] 4 이상일 경우 이동
  - [x] 4 미만일 경우 정지



---
참고사항

[커밋 메시지 컨벤션 URL]: https://gist.github.com/stephenparish/9941e89d80e2bc58a153
[프리코스 과제 제출 문서 URL]: https://github.com/next-step/nextstep-docs/blob/master/precourse
[자바 코드 컨벤션 URL]: https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
[일급콜렉션을 활용 URL]: https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
[모든 원시값과 문자열을 포장 URL]: https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/
