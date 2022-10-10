
## 구현 기능 목록
- 입력
  - [x] 쉼표 기준으로 전체 자동차 이름 입력받기
    - [x] [예외] 공백 입력 혹은 콤마만 입력된 경우
      - IllegalArgumentException("참가할 자동차 이름이 입력되지 않았습니다.");
  - 자동차 생성
    - [x] 자동차 객체 생성 (이름 입력받기)
    - [x] [예외] 자동차 이름 길이 : 0
      - IllegalArgumentException("공백인 자동차 이름을 입력할 수 없습니다.")
    - [x] [예외] 자동차 이름 길이 : 5 초과
      - IllegalArgumentException("자동차 이름의 길이는 5 글자 이하여야 합니다.") 
  - 이동 횟수 입력
    - [x] [예외] 0 입력 혹은 입력되지 않는 경우
      - IllegalArgumentException("이동 횟수가 입력되지 않았습니다.");
    - [x] [예외] 숫자가 아닌 다른 문자 입력
      - IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다."); 

- 자동차 경주 진행
  - [X] 랜덤 값 생성 (1-9, 4 이상 전진, 3 이하 멈춤)
  - 자동차 전진, 멈춤
    - [x] 4이상 값 입력 시 전진
    - [x] 3이하 값 입력 시 멈춤

- 출력
  - 진행 상황 출력
    - [x] 각 자동차 별로 진행 횟수 출력
    - [x] 입력한 이동 횟수만큼 반복 출력
  - 우승자 출력
    - [x] 한 명 우승 : 출력
    - [x] 공동 우승 : 쉼표(,)로 이름 구분하여 출력

- 예외 처리 공통 사항
  - 예외 발생 시 에러 문구 출력, 에러 문구는 [ERROR]로 시작함
    - ex) [ERROR] 시도 횟수는 숫자여야 한다.
  - 사용자 값이 잘못 입력된 경우 IllegalArgumentException 에러 출력 후 해당 부분부터 입력을 다시 받기
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형 처리