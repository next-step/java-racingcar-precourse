# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---
## 요구사항 상세
* 기능
  * 자동차 이름 쉼표(,) 기준으로 구분하기
  * 0과 9사이의 랜덤값 생성하기
  * 자동차 전진가능 여부
  * 문자열 입력으로 자동차 리스트 생성
  * 위치 기준 자동차 리스트 내림 차순 정렬
  * 일등(우승자) 자동차 리스트 얻기
* 입력
  * 자동차 이름 입력 받기
  * 시도할 횟수 입력 받기
* 출력
  * 자동차 이름 입력 문자열 출력
  * 시도할 회수 입력 문자열 출력
  * "실행 결과" 문자열 출력
  * 시도 횟수별 결과 상세 출력
  * 각 자동차별 진행위치를 대쉬로 출력
  * 우승자 출력
* 기타
  * 자동차의 일급콜렉션 구현
  * 원시값과 문자열의 포장

---
## MVC Pattern에 따라 리팩토링
* 컨트롤러(Controller)
  * 자동차 이동 여부에 따라 위치 갱신(updateEachCar)
  * 게임의 턴을 수행하기(proceedEachTurn)
* 모델 - 자동차 모델(Car)
  * 자동차 이름/위치 저장 및 얻기(getter/setter)
  * 자동차 이동하기(forward)
* 자동차 일급콜렉션(Cars)
  * 자동차 리스트를 인수로 받는 생성자
  * 불변 자동차 리스트를 얻는 함수(getCarList)
  * 자동차 이름 유효성 체크 함수(validateCarNameLength)
* 게임 기능(GameUtil)
  * 자동차 이름내 공백제거(removeAllSpaceInCarName)
  * 컴마에 따라 자동차 이름 나누기(splitCarNameByComma)
  * 0 ~ 9사이의 랜덤값 생성하기(generateRandomNum)
  * 랜덤값 이동가능 여부 확인(isMovable)
  * 입력값에 따른 자동차 리스트 생성(createCars)
  * 위치 기준 내림차순 자동차 리스트 정렬(sortCarList)
  * 일등에 위치한 자동차 리스트 얻기(getFirstPositionCarList)
* 뷰(View)
  * 자동차 이름 입력문구 출력(outputInputCarName)
  * 시도 횟수 입력문구 출력(outputInputTryCount)
  * 실행 결과 문구 출력(outputExecutionResult)
  * 시도 횟수별 실행 결과 상세 출력(outputExecutionResultDetail)
  * 자동차 위치 수치에 대한 대쉬 출력(outputDashAsNum)
  * 최종 우승자 자동차 리스트 출력(outputWinner)

