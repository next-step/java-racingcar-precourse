# 구현 기능 목록

## VIEW
- [x] 자동차 이름 입력 받기
  - 이름은 ','로 구분
  - 이름은 5자 이하
  - 사용자가 잘못된 값을 입력할 경우 를 발생시키고 **다시 입력 받기**,"[ERROR]"로 시작하는 에러메시지 출력해야됨
  - Exception 이 아닌 IllegalArgumentException , IllegalStateException 등과 같은 명확한 유형을 처리
- [x] 시도할 횟수 입력 받기
  - 숫자만 입력 받기
  - 사용자가 잘못된 값을 입력할 경우 를 발생시키고 **다시 입력 받기**,"[ERROR]"로 시작하는 에러메시지 출력해야됨
  - Exception 이 아닌 IllegalArgumentException , IllegalStateException 등과 같은 명확한 유형을 처리
- [x] 실행 결과 출력 하기
- [x] 최종 우승자 출력 하기

## MODEL
- [x] 0~9 사이의 랜덤 값 생성
- [x] 자동차 이동 거리 매 시도 마다 갱신
- [x] 우승자 선정

## CONTROLLER
- [x] Model과 View 연결

