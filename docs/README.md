# Car Racing Game

우아한 테크 캠프 Pro 2주차 미션

# 기능 요구사항

- **입력 및 출력**
  - 사용자에게 자동차 이름을 입력받는다.
    - 쉼표 이름으로 자동차를 구분
    - 자동차 이름은 5자 이하
  - 몇 번의 이동이 있을지 입력받는다.
  - [I/O 정리](https://github.com/dhslrl321/java-racingcar-precourse/blob/master/docs/io-example.md)
- **사용자의 잘못된 값**
  - `IllegalArgumentException("[ERROR] ...")` 출력 후 해당 부분만 다시 입력
- **전진 조건**
  - `0 <= random` && `random <= 9`
  - 전진 : `random >= 4`
  - 중지 : `random <= 3`
- **우승 조건**
  - 가장 많이 간 자동차
    > 전진 조건 (`random >= 4`) 에 가장 많이 포함된 자동차

# Diagram

## Domain

![domain](https://github.com/dhslrl321/java-racingcar-precourse/blob/master/docs/images/domain.png)

## Domain Modeling

![domain](https://github.com/dhslrl321/java-racingcar-precourse/blob/master/docs/images/domain-modeling.png)

## 문서

- [I/O 정의 및 문서화](https://github.com/dhslrl321/java-racingcar-precourse/blob/master/docs/io-example.md)
- [백로그](https://github.com/dhslrl321/java-racingcar-precourse/blob/master/docs/backlog.md)
