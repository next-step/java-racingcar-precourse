## 기능 목록
- [] 사용자 입력 부분 구현
  - [x] 자동차 이름 입력 부분
    - [x] 이름을 쉼표로 구분 
    - [x] 이름은 5글자 이하 가능
  - [x] 진행 횟수 입력 부분
    - [x] 숫자만 입력 가능
  - [x] 잘못된 입력 처리
    - [x] IllegalArgumentException 발생
    - [x] "[ERROR]"로 시작하는 에러 메시지를 출력 후 다시 입력 받기
- [x] 진행 부분 구현
  - [x] 입력받은 횟수만큼 진행
  - [x] 0-9 사이 랜덤한 숫자 생성
  - [x] 숫자가 0~3이면 정지, 4~9이면 전진
- [x] 출력 부분 구현
  - [x] 사용자 입력 부분 출력
  - [x] 진행 상태 출력
  - [x] 결과 출력
    - [x] 우승자가 2명 이상인 경우 쉼표로 이름을 구분 
  - [x] 에러 출력



## 프로그래밍 요구 사항
- [x] 프로그램의 시작점은 src/main/java 폴더의 racingcar.Application의 main()이다.
- [x] JDK 8 버전에서 실행가능해야 한다.
- [x] JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils 에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- [x] src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [x] indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
- [x] 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단 람다는 사용 가능하다.
- [x] else 예약어를 쓰지 않는다.
- [x] 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- [x] 도메인 로직에 단위 테스트를 구현해야 한다. 단 UI(System.out, System.in, Scanner)로직은 제외
- [x] (New) 일급콜렉션 활용하여 구현한다.
- [x] (New) 모든 원시값과 문자열을 포장한다.