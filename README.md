# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기본적인 요구사항
1. 기능 요구사항

   1. 자동차
      -[X] 전진할 수 있다
      -[X] 이름을 부여할 수 있다
      
   2. 경주 룰 
      - [X] 주어진 횟수 동안
        - [X] 이동이 가능하다
        - [X] 제동이 가능하다
      - [X] 각 자동차의 이름은 쉼표로 구분하여 입력한다 
        - [X] 이름은 5자 이하만 가능하다 
      - [X] random으로 얻은 1-9사이의 값
        - [X] 4이상일 경우 전진
        - [X] 3이하일 경우 멈춘다 
      - [X] 게임을 완료하면 우승자를 알려준다 
        - [X] 우승자가 한명 이상일 경우
        - [X] ','로 이름을 구분해서 출력한다.
          
   3. 사용자가 잘못 된 값을 입력할 경우 
      - [X] IllegalArgument, IllegalStateException 등 명확한 Exception을 발생시킨다
      - [X] 에러는 [ERROR] 로 시작하게 구성한다
      - [X] 에러 발생시 해당 부분부터 다시 입력 받는다
2. 입출력 요구사항
   * 요구사항 파일 별도 확인
3. 프로그래밍 요구사항
   1. 기본사항
      - [X] 시작부는 Application.main()
      - [X] JDK 8 환경에서의 실행
      - [X] 유틸 사용 규정
        * Random 및 Scanner의 사용
            * Random
              * camp.nextstep.edu.missionutils.missionutils.pickNumberInRange()
            * ReadLine
              * camp.nextstep.edu.missionutils.Console.readLine()
      - [X] 기본적으로 주어진 2개의 Test Case를 모두 만족해야 한다.
   2. 코드 작성 규정
      - [X] 1주차 내용
      - [X] 일급 콜렉션을 활용한 구현
      - [X] 모든 원시값과 문자열을 포장
   3. 도메인 로직에 단위 테스트를 구현해야 한다
      - [X] TDD 시행 여부 
## 과제 진행상 Rule
1. 1주차에 제대로 시행하지 못했던 TDD 시행
2. 1번 항목을 통한 기능 단위 commit 진행
