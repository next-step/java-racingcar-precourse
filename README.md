# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

# 2주차 - 자동차 경주 게임

[ 모델 ]

- 유저
- 자동차
- 게임 승자
- 게임 규칙

[ 요구사항 ]

- 유저는 몇 번의 이동을 할 것 인지 횟수를 입력
- 유저는 각 자동차에 이름을 부여

- 전진하는 자동차를 출력 할 때 자동차 이름을 같이 출력
- 전진하는 조건은 0~9 까지 랜덤값을 구한 후 4이상일 경우 전진 3이하 일 경우 멈춘다.
- 자동차 경주 완료 후 누가 우승했는지 알려준다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생시키고 [ ERROR ] 로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- Exception이 아닌 IllegalArgumentException , IllegalStateException 등 같은 명확한 유형을 처리

- 일급 컬렉션 사용하기
- 모든 원시값과 문자열을 포장한다.

