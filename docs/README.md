## 자동차 경주 구현 목록

-------
* [ ] 입력 View
    * [ ] 자동차 시도횟수 메시지 출력 및 입력
    * [ ] 자동차 이름 메시지 출력 및 입력


* [ ] 출력 View
    * [ ] 자동차 이름과 문자 "-" 을 출력
      > pobi: ---<br>
      you: -----

    * [ ] 우승차 출력 메시지
      > 최종 우승: pobi, you


* [X] 도메인별 기능
    * [X] 자동차 이름 쉼표(,)를 기준으로 n대 입력받음
    * [X] 이동할 횟수 입력받음
    * [X] 1 ~ 9 랜덤숫자 생성
    * [X] 차 이동
        * [X] 랜덤 값이 4 ~ 9 사이일 경우만 이동
    * [X] 우승차 조회


* [X] 유효성 체크
    * [X] IllegalArgumentException 처리
        * [X] 이동조건 값 1 ~ 9의 범위에 없는 경우
        * [X] 차이름 5글자 초과
        * [X] 차이름 공백
        * [X] 차이름 중복

* [X] 도메인 객체 분리
    * [X] RacingGame
        * [X] TryCount 객체 포장
        * [X] Cars 객체 포장
        * [X] 모든차 이동
        * [X] 레이싱 상태 조회
    * [X] Car
        * [X] Movable 전략패턴
        * [X] Position 객체포장
        * [X] CarName 객체포장
        * [X] 이동상태 변경
    * [X] Name
        * [X] 유효성체크
            * [X] 글자가 5자 초과시 예외
            * [X] 공백일경우 예외
        * [X] 일급 컬렉션
    * [X] Cars
        * [X] 모든차 이동
        * [X] 우승차들 조회
    * [X] Position
        * [X] Position 증가
        * [X] Position 값 생성자 초기화
        * [X] Position 값 비교
    * [X] WinnerCars
        * [X] 가장 많이 이동한 차 조회
    * [X] MovableStrategy
        * [X] RandomMove
    * [X] NumberGenerator
      * [X] 1~9 사이 숫자 생성
    * [X] TryCount
        * [X] 시도횟수 증가 
        * [X] 시도횟수 초과시 예외
        * [X] 시도횟수 기준 완료유무
----
