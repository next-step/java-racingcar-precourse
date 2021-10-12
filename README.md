# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록 
* 자동차 (Car, 컬렉션은 Cars)
  * 자동차 이름 (CarName)
    * 사용자가 다섯 글자 이하의 자동차 이름을 입력했는지 검증 
    * toString() 재정의
  * 이동한 거리 (Distance)
    * 랜덤값이 4 이상일 경우 전진, 3 이하일 경우 멈춤
    * toString() 재정의
  * 자동차 이름과 이동한 거리의 toString()을 바탕으로 toString() 재정의 (전진 출력 시 호출)
* 몇 번의 이동 (Cycle)
  * 사용자의 입력값이 0 이상의 숫자인지 검증
* 자동차 경주 (RacingGame)
  * 게임 시작
  * 경기 시작 
  * 최종 우승자들을 출력
* 승자 (Winners)
  * 자동차들을 distance 순으로 정렬
  * 정렬된 자동차들을 토대로 최종 우승자들을 선별
