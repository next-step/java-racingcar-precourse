# java-racingcar-precourse

---
# 구현 기능 명세
## 1. Model
1. Car 클래스
    - 상태정보: 이름, 전진 거리
    - 기능
        - move() : 0~9까지의 난수 중 4 이상의 값을 가질시 전진 거리 증가
        - getProgress() : 전진 현황 반환 (이름 : '-' x 전진거리)
2. Info 클래스
    - 상태정보: Car list, 이동 횟수
    - 기능
        - insert() : 입력 문자열을 통해 Car list 초기화
        - round() : 모든 Car를 이동시킨 후 이동 횟수 차감
        - getProgressList() : 모든 Car의 전진 현황 list 반환
        - isFinish() : 남은 이동 횟수가 0이라면 최대 전진 거리를 가지는 Car list 반환
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