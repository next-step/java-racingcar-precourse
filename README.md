# java-racingcar-precourse

## 구현할 기능 목록

### 자동차 이름 입력 처리

- 쉼표(,)를 기준으로 구분하며 이름은 5자 이하
- 잘못된 값인지 체크 &rarr; IllegalArgumentException
  - 이름이 0자일 경우
  - 이름이 6자 이상 경우
  - 아무 입력도 안들어온 경우

### 시도 횟수 입력 처리

- 잘못된 값인지 체크 &rarr; IllegalArgumentException
  - 숫자가 아닌 경우

### 차들의 전진, 정지 난수 생성

- 0~9
  - 0~3 : +1
  - 4~9 : 0

### 차들 distance update 구현

### winner check 구현

### 메시지 출력

- 자동차 이름
- 시도 횟수
- 시간에 따른 결과
- 우승자
