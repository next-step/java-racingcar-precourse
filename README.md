# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

# 기능 설계
## 1. 게임 진행 전 유효성 검사
### 1) 경주할 자동차 이름 입력
* 입력받은 값의 공백을 제거하는 로직 필요
* 이름이 5자 이상이거나, 이름 없이 ','가 이어질 경우 이름을 다시 입력받는다.
    * do while 반복문과 유효성 검사 메서드 사용
### 2) 시도할 횟수 입력
* 입력받은 값의 공백을 제거하는 로직 필요
* 입력한 값이 숫자가 아니거나, 1보다 작은 숫자일 경우 다시 입력받는다.
    * do while 반복문과 유효성 검사 메서드 사용

## 2. 게임 진행 전 클래스, 변수 설계
### 1) 이름과 점수를 갖고 있는 Player 클래스 추가
* 클래스 내부에 getter, 점수 추가, 결과 출력 메서드 추가
### 2) Player의 컬렉션과 시도 횟수, 유효성 검사 변수 추가
* 각각 List<Player>, Integer, boolean 사용

## 3. 게임 진행
### 1) 입력받은 시도 횟수 만큼 for문 안에서 진행
* 게임 진행 관련 메서드를 포함하는 클래스 추가
### 2) Randoms 클래스, Player 클래스 내부의 메서드 사용
* pickNumberInRange(0, 9)의 결과가 4 이상일 경우 점수 추가 메서드를 통해 +1점
* 점수 추가 후 결과 출력
* 해당 로직을 입력받은 시도 횟수 만큼 반복

## 4. 결과 출력
### 1) 게임이 끝난 후 List 내 점수가 가장 높은 Player를 찾아낸다
* Comparator 구현해 max 메서드 사용
### 2) 해당 Player와 점수가 같은 Player들을 다시 List에 담고 결과를 출력한다

# 원시값 포장을 기초로 한 재설계 (2021/10/11)
## 기존 : Player, PlayerComp, GameUtil, ValidationUtil
## 변경 후 : Player, PlayerComp, PlayerName, PlayerNames, PlayerScore, Attempt, PlayGame, LastResult

# 재설계 상세
## Player
* 기존 Player가 갖고 있던 name과 관련 메서드를 PlayerName, PlayerNames 객체로 관리
* 기존 ValidationUtil에서 갖고 있던 Player의 name에 대한 유효성 검사를 PlayerName 객체로 관리
    * 사용자가 입력한 경주할 자동차 이름들을 PlayerNames의 생성자로 받아 PlayerName의 컬렉션을 생성한다
    * 이 과정에서 PlayerName의 생성자를 사용하며 해당 생성자 안에서 유효성 검사를 진행한다
* 기존 Player가 갖고 있던 score와 관련 메서드들을 PlayerScore 객체로 관리
* 기존 GameUtil에서 갖고 있던 score에 대한 관리를 PlayerScore 객체로 관리
    * score에 대한 접근, score의 증가 및 증가에 대한 조건 검사를 PlayerScore에서 관리
    
## Attempt
* 기존 ValidationUtil에서 갖고 있던 시도 횟수에 대한 유효성 검사를 Attempt 객체에서 관리

## Game
* 기존 GameUtil에서 갖고 있던 게임 진행 및 결과 출력에 대한 메서드를 Game, LastResult 객체로 관리
    * Player의 컬렉션을 Game 생성자에 주입
    * 게임 진행에 대한 반복문을 Game 객체에서 관리하고, 각각에 대한 결과 출력은 Player의 메서드 사용
    * Player의 컬렉션을 LastResult 생성자에 주입
    * 결과 출력에 대한 로직은 기존과 비슷하지만, 기능을 나눔으로써 보다 직관적인 이해 가능

