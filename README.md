# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


자동차
- 이름 필드 게터 세터(유효성 체크: 5자 이하)
- 위치 필드 게터 세터  
- 전진 기능 
- 멈춤 기능

사용자 
- 이동 횟수 입력

라운드 
- 라운드별 레이싱 결과 저장 

규칙
- 전진 후진 판단 조건: 0 에서 9 사이에서 random 값을 구한후 random 값

메세지
- 경기 관련 메세지 enum 

게임
- 경기 시작
- 우승 판단

에러
- IllegalArgumentException
- IllegalStateException

