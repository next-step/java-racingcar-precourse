## Racing Car Game

### Feature List

- [ ] 사용자가 입력한 차량의 이름을 분리한다.
  - Delimiter는 **,** 를  기준으로 한다.
    * 예외 상황

      |내용   |Exception|
      |---|---|
      | 차량 이름이 없거나 5자 초과하는 경우 |IllegalArgumentException|
      | 차량 이름에 중복이 있는 경우  |IllegalArgumentException|

- [ ] 경기 진행 : 각 차량당 전진과 멈춤을 임의의 수 (0\~9) 를 통해 결정 ( 멈춤 0\~3, 전진 4\~9 )

- [ ] 사용자가 입력한 시도 횟수 만큼 경기를 진행하고 결과를 Collection에 저장
    * 예외 상황

      |내용   |Exception|
      |---|---|
      | 시도 횟수가 숫자가 아닌 경우     |IllegalArgumentException|
    
- [ ] 모든 라운드 종료시 우승자 확인
    - 공동우승 가능

> 입력에 대한 예외상황 발생시 [ERROR] 형태의 에러 메세지를 출력하고 다시 입력받는다. 