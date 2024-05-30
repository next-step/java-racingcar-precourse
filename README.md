# java-racingcar-precourse

---
# 구현 기능 명세
## 1. Model
1. Car 클래스
    - 상태정보: 이름, 전진 거리
    - 기능
        - move() : 전진 거리 증가
        - getProgress() : 전진 거리 반환
2. Info 클래스
    - 상태정보: Car list, 이동 횟수
    - 기능
        - insertNames() : ','로 구분된 자동차 이름 문자열로 Car list 초기화
        - round() : 
          - list 내의 모든 Car에 대해 임의의 난수(0 ~ 9) 생성 후,<br>
          해당 난수가 4 이상이면 move() 호출<br>
          이후 이동 횟수 - 1
        - getProgressList() : 모든 Car의 전진 현황을 문자열로 반환
        - isFinish() : 남은 이동 횟수가 0인지 판단
        - getWinner() : 전진 거리가 최댓값인 Car들의 이름을 (, )로 구분한 문자열 반환
## 2. View
1. InputView
    - 경주할 자동차 이름과 이동 횟수를 입력 받고 반환
2. ProgressView
    - 이동 현황 출력
3. PrintWinner
    - 최종 우승자 list 출력
## 3. Controller
1. RaceController
    - 입력 값 유효성 판단
    - 전체 흐름 제어
2. Validator
    - InputValidator : 입력 이름 공백 및 길이 검사
    - InputCountMissMatchValidator : 이동 횟수 입력 데이터 타입 검사
    - InputCountValidator : 음수 입력 검사
    - DuplicationValidator : 중복 이름 검사