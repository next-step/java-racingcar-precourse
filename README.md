# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 추가 요구사항
- 일급 콜렉션을 활용해 구현해야 한다.
  - 참고 링크 : https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
- 모든 원시값과 문자열을 포장한다.
  - 참고 링크 : https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/

## 기능 목록
- [x] 입력 받은 이름으로 자동차를 생성한다.
  - 자동차 이름은 빈 값일 수 없고, 5자 이하만 가능하다. 
    <br>
    (빈 값이거나 5자 초과시 오류 발생)
- [x] 자동차를 전진 또는 멈춘다.
  - 0 ~ 9 사이에 random 값을 구하고, 4 이상일 경우 전진, 3 이하인 경우 멈춘다.
- [x] 사용자에게 자동차 이름, 시도 횟수를 입력받는다.
  - 자동차 이름 : 각 자동차 이름은 빈 값일 수 없고, 5자 이하만 가능하다. (빈 값이거나 5자 초과시 오류 발생)
  - 시도 횟수 : 숫자이고 1 이상이여야 한다.
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
- [x] 자동차의 실행 결과를 출력한다.
  - 자동차 이동 시, 각 자동차의 위치 '-'로 출력한다.
    <br>
    (postion 1당 '-' 하나로 출력 : Car(name: 'pobi', position: 2) → 'pobi:--' 출력)
- [x] 자동차의 최종 우승자를 출력한다.
  - 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해서 출력한다.

## 코드 컨벤션
- [Java Style Guide 준수](https://google.github.io/styleguide/javaguide.html)
  - 블럭 들여쓰기: +4 스페이스
  - 열 제한: 120
  - 들여쓰기 지속은 최소 +8 스페이스
  - 수직 빈줄 ...
- indent(들여쓰기) depth - 1까지만 허용
- 자바 8에 추가된 stream api 사용 금지 (람다는 허용)
- else 예약어 금지
- 메서드 길이는 10 라인이 넘어가지 않도록 구현

## 패키지 정보
```shell
racingcar
 ┗ app      # [Controller] 부분
 ┗ domain   # [Model] 클래스
 ┗ io       # 입출력 담당
 ┗ message  # 안내, 오류 메시지 모음
 ┗ util     # 검증 유틸 클래스
 ┗ view     # [View] 부분
```

## CLASS DIAGRAM
![image](https://user-images.githubusercontent.com/93169519/194773030-f7d825fb-aa9a-4b18-bd72-4e25c471f08f.png)

## 콘솔 실행 결과
```shell
경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇 회 인가요?
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

최종 우승자 : pobi,honu
```