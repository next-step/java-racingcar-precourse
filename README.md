# java-racingcar-precourse

# 기능 목록

## 자동차 게임

- 주어진 횟수 동안 n 대의 자동차는 전진 또는 멈출 수 있다.

## 전진 룰

- 값이 4 이상이면 자동차를 전진 시킨다.

## 숫자 뽑기 룰

- 0에서 9 사이에서 무작위 값을 구한다.

## 자동차 목록

- 우승자를 구한다.
    - 우승자는 한 명 이상일 수 있다.
    - 우승자는 위치의 숫자가 가장 높은 자동차이다.

- 포지션이 같은 자동차 목록을 반환한다.

- 포지션이 가장 높은 자동차의 포지션을 반환한다.

## 자동차

- 자동차는 이름을 가진다.
- 자동차는 위치를 가진다.
- 자동차의 위치를 전진 시키면 위치를 1 증가 시킨다.

## 이름

- 자동차 이름은 5자 이하만 가능하다.
    - 자동차 이름이 5자 초과면 IllegalStateException 를 발생시킨다.

## 위치

- 위치를 1 증가 시킨다.
- 위치 값보다 함수로 전달받은 위치 값이 작으면 false 를 반환한다.

# 입출력 요구사항

## 입력 요구사항

- 주어진 문자열을 쉼표를 기준으로 구분한다.
- 숫자를 입력 받는다.
- 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다 시 받는다.

## 출력 요구사항

- 문자열을 출력한다.
- 문자열이 여러 개일 경우 쉼표를 이용하여 구분한다.

