# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## User-end Features

### 1. Game Generation
- 유저가 입력한 Round 횟수만큼 게임이 진행되며, 게임이 종료되었을 때 더 많은 Track을 가진 Car가 우숭한다.
  - 공동우승을 하는 경우, 콤마(,)로 구분하여 공동 우승자를 출력한다.
- 각 Round에서는 Random으로 생성된 값이 전진 가능한 bifurcation을 넘었을 때만 전진이 가능하고, 그렇지 않은 경우 움직이지 않는다.

### 2. User Input
- 유저에게 콤마(,)로 구분된 차량 이름을 입력받는다.
  - 차량 이름은 비어있을 수 없으며, 콤마(,)로 구분된다.
- 차량 이름은 나중에 우승자 표기와 Round마다 Track Record를 표시할 때 사용한다.
- 유저에게 Round 횟수를 입력받는다.
  - Round는 숫자 형식의 값이며, 반드시 1 이상의 Round 로 Game이 구성되어야 한다.
- 잘못된 형식이나 값을 입력했을 때 IllegalArgumentException을 발생시키고 해당 Exception이 발생한 부분부터 다시 입력을 받는다.

### 3. Available Exceptions
- 차량 이름에 대한 예외처리
  - 입력이 비어있는 경우
  - 중복된 이름을 가진 차량이 입력되는 경우
  - 차량 이름이 제한된 길이에 맞지 않는 경우
  - 입력이 콤마(,)로 시작되거나 끝나는 경우 (split의 기준이 될 수 없는 입력의 경우)
- Round 횟수에 대한 예외처리
  - 입력이 비어있는 경우
  - 1보다 작은 값으로 입력되는 경우 (반드시 한번의 게임이 진행되어야 우승의 조건이 됨)
  - 입력이 숫자 형식이 아닌 경우

---

### Project shortcuts

- [PR Destination Repository](https://github.com/next-step/java-racingcar-precourse)
- [Commit Convention](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)
- [Java Convention](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)
- [Pre-course Guide](https://github.com/next-step/nextstep-docs/tree/master/precourse)
- [Submission Form](https://docs.google.com/forms/d/e/1FAIpQLSeoCV20IyBnEwN319hvxEyOY7bELX9jn_wurR8zSYL0kvBmJg/viewform)
