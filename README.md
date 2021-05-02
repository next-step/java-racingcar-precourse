# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---
## 기능 요구사항

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름 부여 (객체 생성), 전진하는 자동차 출력과 동시에 이름 출력
* 자동차 (,)를 기준으로 5자 이하
  * split() 메소드를 통하여 자동차 구분
  * 5자를 초과할 시 예외처리
* 시도할 횟수 입력 (Input)
* 0 ~ 9의 random 값 생성, random >= 4 : 전진, random <= 3 : 정지
  * random 값이 4보다 크거나 같다면 True
  * random 값이 4보다 작다면 False
  * True일 시 해당 자동차 + 1
    * 해당 자동차를 구분하기 위하여 Car 객체 생성
* 자동차 게임을 완료 후 누가 우승했는지 출력, 우승자는 한 명 이상일 수도 있다.

--- 
## 프로그래밍 요구사항

### # 1주차와 동일한 기준

* [자바 코드 컨벤션](https://naver.github.io/hackday-conventions-java/) 을 지킨다.
* indent depth가 2를 넘지 않도록 구현.
* stream api를 사용하지 않는다.
* else 예약어 금지, switch/case 금지
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 주의

### # 추가된 사항

* 일급콜렉션을 활용해 구현한다. [[참고]](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
* 모든 원시값과 문자열을 포장한다. [[참고]](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)

### # 단위 테스트

* 로직에 단위 테스트 구현 (UI 로직은 제외)

---
## 미션 저장소 및 진행 요구사항

* 미션은 [저장소](https://github.com/next-step/java-racingcar-precourse) 를 fork/clone해 시작
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가 
  * [여기](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 를 참고하여 commit log를 남긴다.
* 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/next-step/nextstep-docs/tree/master/precourse) 문서를 참고

 