# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 요구사항 분석
* 자동차 입력 부분
  * 쉼표로 기준을 나누었는지 체크
  * 이름은 5자 이하인지 체크

* 몇 번의 이동이 필요한지 부분
  * 숫자 제한 없음

* 차 이동 랜덤 숫자
  * 0 ~ 9 사이에 random 값 구하기
  * 4 이상일 경우 전진
  * 3 이하일 경우 멈춤

* 출력
  * 우승자 한명 이상일 경우 쉼표
  * 우승자 한명

## 요구사항에 맞추어 함수 생성
* 자동차 입력 부분 : RacingCarService.inputRacingCar()
  * 쉼표로 기준을 나누었는지 체크 : RacingCarService.checkCarNameComma()
  * 이름은 5자 이하인지 체크 : RacingCarService.isNameCheck()
  
* 몇 번의 이동이 필요한지 부분 : RacingCarController.play()
  * 숫자 제한 없음

* 차 이동 랜덤 숫자 : Car.run()
  * 0 ~ 9 사이에 random 값 구하기 RacingCarService.racingCarsPlay
  * 4 이상일 경우 전진  Car.inputNumCheck();
  * 3 이하일 경우 멈춤  Car.inputNumCheck();

* 출력
  * 레이싱 진행 상황 : playResult.getProcessPrint() 
  * 우승자 한명 이상일 경우 / 우승자 한명 : playResult.getResultPrint()

