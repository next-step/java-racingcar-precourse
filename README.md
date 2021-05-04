# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

#[기능구현 List]
 
##Main 
    1) InputView Class로 참가할 자동차 개수와 이름,게임 횟수를 입력 받는다.
    2) Cars class 참여하는 자동차 클래스를 만든다.
        -Car 객체 생성
    3) RacingGame을 시작한다.
        -input: Cars,gameCount
        -output: Winner        
    4) 우승자를 OutputView로 결과를 보여준다.
        -input: Winner

##Name
    -길이검증 (1-5글자 길이만 허용)
    -영어만 사용가능
    -빈칸 금지

##Car
    -현재위치와 Name

##Cars
    -Car 객체 List

##Winners
    -우승자 Car 객체 List

##RacingGame
    -시도할 횟수만큼 game 실행
    -실행 결과 
    -우승자 판별

##InputView
    -경기에 참가할 자동차 이름 입력
    -시도할 회수 입력

## OutputView
    -실행 결과 출력 
    -최종 우승자 출력
