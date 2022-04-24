# 기능 목록

### 자동차는 이름을 가진다. [#1](https://github.com/justxina/java-racingcar-precourse/issues/1) 
- 이름은 5자 이하만 가능하다.
- 이름을 출력할 수 있다.
- 사용자가 여러 대의 자동차 이름을 입력할 때 구분자로 사용하는 문자(,)는 자동차 이름에 포함되어서는 안 된다.

### 레이스에 참가하는 자동차(이하 "레이싱 카")가 있다. [#2](https://github.com/justxina/java-racingcar-precourse/issues/2)
- 레이싱카는 레이스를 할 수 있다.
  - 0에서 9 사이에서 random 값을 구한다.
  - random 값이 4 이상일 경우 한 칸 전진한다.

### 레이싱 경기가 있다. [#3](https://github.com/justxina/java-racingcar-precourse/issues/3)
- 여러 대(n)의 레이싱카가 출전한다.
- 여러 턴(m)으로 이루어진다.
- 레이스가 이루어진다.
  - 한 턴 마다 출전하는 모든 레이싱카가 1회 레이스한다.
  - 모든 턴이 끝나면 레이스가 종료된다.
  - 레이스가 종료되면, 최종 우승자를 출력한다.
    - 가장 많이 전진한 레이싱카가 최종 우승자가 된다.
    - 최종 우승자(레이싱카)는 여러 대일 수 있다.

### 사용자는 레이스에 참가하는 자동차 이름들을 입력할 수 있다. [#4](https://github.com/justxina/java-racingcar-precourse/issues/4)
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
 
### 사용자는 레이싱 경기의 턴 수를 입력할 수 있다. [#5](https://github.com/justxina/java-racingcar-precourse/issues/5)
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
  