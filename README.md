# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 설명
1. 자동차 : Car
    - 전달된 숫자에 따른 이동
    - 이동된 거리 계산

2. N대의 자동차 관리 : Cars
    - 전달된 N개의 이름 만큼 자동차 생성
    - N대의 자동차 각각 랜덤한 숫자로 이동

3. 레이싱 결과 : RaceingResult
    - 우승한 자동차 리스트 추출
    - 우승한 자동차의 이름 리스트 추출

4. 숫자(난수) 생성기
    - 난수 생성

6. View
    - 자동차 이름 입력
    - 시도할 회수 입력
    - 주행 과정 출력
    - 우승자 출력

7. Racing
    - 레이싱 시작
        - view에서 자동차 이름, 시도할 회수 전달받음
        - 전달받은 자동차 이름으로 Cars 생성
        - 전달받은 시도할 회수만큼 모든 자동차 이동(Cars.moveAll)
        - 우승자 출력

## 클래스간 로직 흐름
![class-logic-image](https://raw.githubusercontent.com/cobiyu/java-racingcar-precourse/cobiyu/src/main/resources/logic.jpeg)

## 클래스 다이어그램
![class-diagram](https://raw.githubusercontent.com/cobiyu/java-racingcar-precourse/cobiyu/src/main/resources/class.jpeg)
