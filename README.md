# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


## 커밋 메세지

* feat     : 새로운 기능 추가
* fix      : 버그 수정
* refactor : 프로덕션 코드 리팩토링
* comment  : 필요한 주석 추가 및 변경
* docs     : 문서를 수정
* test     : 테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X)
* rename   : 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
* remove   : 파일을 삭제하는 작업만 수행
* chore    : 빌드 테스트 업데이트, 패키지 매니저를 설정 (프로덕션 코드 변경 X)
* style    : 코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우


## 자동차 게임 제약 사항

* 자바8로실행하는지확인
* JDK에서제공하는Random및ScannerAPI대신camp.nextstep.edu.missionutils에서제공하
  는Randoms및ConsoleAPI를사용
* ApplicationTest에있는2개의TestCase가성공해
  야한다
* 자바 코드 컨벤션 구글코드스타일
* depth 1까지만 허용
* 자바8에 추가된 streamapi를 사용하지않고 구현
* 함수(또는메소드)의 길이가 10라인을 넘어가지 않도록 구현
* 일급 콜렉션활용, 모든 원시값과 문자열을 포장
* UI 제외한 도메인 로직에 단위 테스트를 구현


## 기능목록 

* 랜덤 0-9 숫자 호출
* 자동차 이름 validation 5자 이하, 파싱
* 레이스 도메인 (자동차 List, 회차)  자동차 도메인(자동차 이름 , 전진 거리) 작성
* 전진, 후진 구분 ( 4이상이면 전진, 3이하면 stop)
* messageUtil  자동차 회차별 이동 표시  및  게임 메세지 
* 잘못된 값 입력 시 IllegalArgumentException 발생  [ERROR]로 시작하는 에러 메시지를 출력 및 다시 입력 받도록 
