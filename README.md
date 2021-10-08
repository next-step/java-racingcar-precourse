# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
---
## 🚀목표 : 메서드 분리(1주차 미션) + 클래스 분리 

## 📝구현할 기능 목록 (21.10.07 작성)
* 원시값 포장`(21.10.08 추가)`
    * 0 ~ 9 까지 랜덤값 입력을 위한 클래스 생성
    <br><br>
* 자동차 생성
    * n대의 자동차 생성 가능
    * 전진 또는 멈춤 기능 필요
        * 랜덤 값 범위 : 0 ~ 9
        * 전진 : random 값 4 이상
        * 멈춤 : random 값 3 이하
    * 자동차 이름은 5자 이하만 가능
    <br><br>
* 우승 처리
    * 가장 많이 전진한 자동차(?)
    * 우승 자동차 이름 출력
    * 우승 자동차가 여러 대라면 쉼표(,)로 구분해 출력한다.
    <br><br>
* 예외 처리
    * 사용자가 잘못된 값을 입력하면 `[ERROR]`로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.
    <br><br>
* 게임 순서
    * 경주할 자동차 이름 입력
    * 시도할 횟수 입력
    * 실행 결과 출력
    * 우승자 출력
    * 게임 종료
---
## 🔧1차 과제에서 부족했던 부분 (21.10.08 작성)
* 들여쓰기`1`제한 위반 (반복문)
    > 1차 과제 목표인 메서드 분리를 통해 줄일 수 있었을 것이다.
    ```java
    while(condition) {
      if(condition) {
        ...
      }
    }
    // or
    for (condition) {
      if(condition) {
        ...
      }
    }
    ```
## 🎁원시값을 포장하라
> integer 변수를 사용할때 보다 예외처리, 값 제어 등 유리한 부분이 많은 것 같다.
```java
public class Positive {

    private int value;

    /**
     * String 값을 넘겨받는 생성자
     *
     * @param value 전달받은 숫자 문자열
     */
    public Positive(String value) {
        int integer = Integer.parseInt(value);
        validatePositive(integer);
        this.value = integer;
    }

    /**
     * int 값을 넘겨받는 생성자
     *
     * @param value 전달받은 숫자
     */
    public Positive(int value) {
        validatePositive(value);
        this.value = value;
    }

    /**
     * value 값을 1 증가하는 로직
     */
    public void plus() {
        value++;
    }

    /**
     * @return 멤버변수 value 값을 반환
     */
    public int get() {
        return value;
    }

    /**
    * @param value 전달받은 숫자
    * @throws IncorrectInputException 입력한 수가 0 ~ 9 범위를 벗어난 경우 발생한다.
    */
    private void validatePositive(int value) {
        if (value < 0 || 9 < value) {
            throw new IncorrectInputException("0 ~ 9 범위를 벗어난 수를 입력할 수 없습니다.");
        }
    }
}
```