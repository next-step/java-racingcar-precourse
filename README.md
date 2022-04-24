# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.



## 기능 요구 사항
  * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  * 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  * 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  * 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
  * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈
    춘다.
  * 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
  * 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
  * 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를
    출력 후 그 부분부터 입력을 다시 받는다.
  * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 입출력 예시 
* 입력
    ```text
    > 경주 할 자동차이름(이름은쉼표(,)기준으로구분) 
    > pobi,woni,jun
    > 시도할 회수
    > 5 
    ```
  
  * 출력 
  ```text
  > 각차수별실행결과
  > pobi : —— woni : --- jun : ----
  > 단독우승자안내문구 최종 우승자: pobi
  > 공동우승자안내문구 최종 우승자: pobi, jun
  
  /* 예외상황시에러문구를출력해야한다.단,에러문구는 [ERROR]로 시작해야 한다. */
  > [ERROR] 시도 횟수는 숫자여야 한다.
   ```
## 기능 목록

- [X] 자동차 전진 혹은 멈추는 기능 
    * Random 값은 0 ~ 9 사이 해당값이 아닐 경우 IllegalArgumentException 발생  
    * 전진 : Random 값의 4이상일 경우 전진
    * 멈춤 : Random 값이 3이하일 경우 멈춤 
  
- [X] 자동차 이름을 설정하는 기능 
    * 자동차의 이름은 5자이하
    * 위 사항이 충족하지 못할시 IllegalArgumentException 발생
  
- [X] 자동차들을 생성하는 기능  
    * 쉼표를 기준으로 자동차들을 입력 받음
  
- [X] 자동차들이 경주 하는 기능
    * 랜덤 값을 받아 자동차들을 경주하여 상태값을 업데이트 한다.

- [X] 사용자가 자동차들의 이름을 입력 받는 기능
  - IllegalArgumentException 발생시 에러메시지 와 재입력

- [X] 경주 횟수를 입력 받는 기능
    * 숫자가 아닐시 IllegalArgumentException 발생

- [X] 횟수 1차수씩 끝날때 자동차의 상태를 출력 하는 기능 
    * 출력 예시 차이름 : -
  
- [X] 우승자를 선별하는 기능
  * 공동 우승시 , 구분 

- [X] 사용자가 입력값을 잘 못 입력 시 재 입력 하는 기능 
  - IllegalArgumentException 발생
  - [ERROR]로 시작하는 에러 메시지를 출력 하고 재 입력처리

## 구현 클래스 
- RaceingcarController
  - 레이싱 게임 컨트롤러 
- domain 
  - Car : 자동차 클래스
    - 자동차의 전진 멈춤 담당
  - CarList : 자동차들의 일급 컬랙션 
    - 승자 탐색
    - 자동차들의 레이스
  - CarName
    - 자동차의 이름 원시값 포장 클래스
    - 자동차이름의 벨리데이션 담당
  - MoveStatus
    - 전진, 멈춤에 대한 상태 
  - Position
    - 자동차의 위치에 대한 일급 컬랙션
- util
  - MessageUtils
    - 메시지에 대한 Util 클래스
  - StringUtils
    - 스트링 넘버에 대한 검증을 위한 StringUtil 클래스
- view 
  - InputView 
    - 데이터 입력에 대한 화면 담당 
  - OutPutView
    - 화면 출력에 대한 화면 담당
## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
