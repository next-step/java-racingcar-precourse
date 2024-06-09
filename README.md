# java-racingcar-precourse

## 구현 기능 목록

### 자동차의 이름 입력

  * 이름은 쉼표로 구분하고, 5자 이하만 입력이 가능합니다.

  * 잘못된 입력 시 `IllegalArgumentException`이 발생하고 다시 입력을 받습니다.

### 이동 횟수 입력

  * 사용자는 몇 번 이동할 것인지 횟수를 입력 합니다.

  * 마찬가지로 잘못된 입력 시 `IllegalArgumentException`이 발생하고 다시 입력을 받습니다.

### 자동차 앞으로 전진

  * 자동차마다 0부터 9까지의 무작위 값을 생성하고 4 이상일 시 한 칸 전진합니다.

  * 전진이 끝나면 진행 결과를 출력합니다.
  * 이 과정은 사용자로부터 입력 받은 이동 횟수만큼 반복됩니다.

### 완주 및 우승자 판단

  * 가장 많이 전진한 자동차가 우승자로 선정됩니다.

  * 최종 우승자를 출력합니다.
