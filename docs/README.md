## Racing Car Game

### Feature List

- [X] 입력한 자동자이름(문자열)에 대한 경주에 참여하는 자동차 목록으로 생성
    * [X] 사용자가 입력한 자동차의 이름을 분리한다.
        - Delimiter는 **,** 를  기준으로 한다.

    * [X] 예외 상황

      |내용   |Exception|
      |---|---|
      | 자동차 이름이 없거나 5자 초과하는 경우 |IllegalArgumentException|
      | 자동차 이름에 중복이 있는 경우  |IllegalArgumentException|
      | 자동차 이름이 2개 미만인 경우 |IllegalArgumentException|
      | 자동차 이름의 끝이 쉼표(,)로 끝나는 경우  |IllegalArgumentException|

- [X] 각 자동차당 전진과 멈춤을 임의의 수 (0\~9) 를 통해 결정 ( 멈춤 0\~3, 전진 4\~9 )

- [X] 사용자가 입력한 시도 횟수 만큼 경기를 진행
    * [X] 라운드 진행에 따른 결과 저장
    * [X] 게임 결과에 대한 우승자 확인 (공동 우승 가능) 
    * [X] 예외 상황

      |내용   |Exception|
      |---|---|
      | 시도 횟수가 숫자가 아닌 경우     |IllegalArgumentException|
      | 시도 횟수가 양수가 아닌 경우     |IllegalArgumentException|
      | 시도 횟수 범위가 너무 큰 경우    |IllegalArgumentException|

- [X] 각각의 사용자 입력에 Exception이 발생하는 경우 다시 재입력

- [X] 전체 라운드에 대한 결과 메세지 출력

- [X] 우승자 목록에 대한 결과 메세지 출력

> 입력에 대한 예외상황 발생시 [ERROR] 형태의 에러 메세지를 출력한다.. 