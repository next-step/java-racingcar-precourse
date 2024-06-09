# java-racingcar-precourse

## 요구사항
### 프로그래밍 요구사항
**요구사항1**<br>
1. JDK 17 버전에서 실행 가능해야 한다.
2. 프로그램 실행의 시작점은 Application 의 main() 이다.
3. build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
4. 프로그램 종료 시 System.exit() 를 호출하지 않는다.
5. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
6. 자바 코드 컨벤션을 지키면서 프로그래밍한다.

**요구사항2**<br>
1.  기본적으로 Google Java Style Guide을 원칙으로 한다.
    단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.<br>
2. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.<br>
   예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.

### 기능 요구 사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. <br>
   Exception 이 아닌 IllegalArgumentException , IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 구현 기능
1. 사용자 입력
    - 자동차 이름 입력
    - 실행 횟수 입력
2. 입력값 유효성 검사
    - 공백 입력 허용하지 않는다
    - 자동차 이름이 5자 이하로 제한
    - 자동차 이름으로 공백은 허용하지 않는다.
3. 경주 시작
    - 각 자동차마다 난수로 전진 여부 결정
    - 실행 횟수만큼 반복한다.
4. 우승자 선정
    - 가장 많이 전진한 자동차를 우승자로 선정한다.
5. 우승자를 출력한다.