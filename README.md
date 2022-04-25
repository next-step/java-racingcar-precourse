# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

# 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
* 사용자는 몇번의 이동을 할것인지를 입력할 수 있어야 한다. 
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다. 
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 
* 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다. 
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,"[ERROR]"로 시작하는 에러메시지를 출력 후 그 부분부터 입력을 다시받는다. 
* Exception이 아닌 IllegalArgumentException, IllegalStateException등과 같은 명확한 유형을 처리한다.
* 입출력 요구사항
  * 입력: 
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    시도할 회수는 몇회인가요?
    5
  * 출력: 각 차수별 실행 결과, 단독 우승자 안내 문구 또는 공동우승자 안내 문구
    실행 결과
    pobi : ——
    woni : ---
    jun : ----
    최종 우승자 : pobi  또는  최종 우승자 : pobi, jun
  * 예외 상황시 에러문구를 출력해야 한다. 단, 에러문구는 [ERROR]로시작해야한다. [ERROR]시도횟수는숫자여야한다.
* 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out,System.in,Scanner) 로직은 제외 
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다. 
  * 힌트는 MVC패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한 단위테스트를 추가하는 것에 집중한다.
* 프로그래밍 요구사항 (신규)
  * 일급콜렉션을 활용해 구현한다. 참고문서:https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
  * 모든 원시값과 문자열을 포장한다. 참고문서:https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4