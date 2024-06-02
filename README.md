# java-racingcar-precourse

# 기능 요구 사항

쉼표로 구분된 임의 개수의 자동차 이름을 입력받는다
   1. [X] 자동차 이름이 0 ~ 5자를 벗어나면 IllegalArgumentException
   2. [X] reading, trailing 공백 문자 무시
   3. [X] 연속된 공백의 문자는 하나로 처리
   4. [X] 에러 출력 후 이동 횟수를 다시 입력받는다.

이동 횟수를 입력 받는다.
   1. [X] 입력이 정수가 아니면 IllegalArgumentException
   2. [X] 이동 횟수 < 1 이면 IllegalArgumentException
   3. [X] 에러 출력 후 이동 횟수를 다시 입력받는다.
   

자동차 경주
   1. [X] 실행 결과 프롬프트 출력
   2. [X] 랜덤 숫자 생성
   3. [X] 생성된 숫자로 전진 여부 결정
   4. [X] 전진한 경우 자동차의 현재 상태 변경
   5. [ ] 매 턴마다 모든 자동차의 현재 상태 출력

경주 결과 출력
   1. [ ] 모든 공동 우승자의 이름을 출력
   2. [ ] 각 이름은 쉼표로 구분 (ex: aaa, bbb, ccc)
    
