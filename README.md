# java-racingcar-precourse

## Model
### Car
- [x] 자동차 이름 저장
- [x] 자동차 현재 위치 저장
- [x] 자동차 전진 기능
### Race
- [x] 현재 자동차 상태 저장
- [x] 최종 우승자 조회 기능
    - 두 명 이상의 우승자 발생 가능
## View
### InputView
- [x] 자동차 이름 입력
- [x] 시도 횟수 입력
### OutputView
- [x] 실행 결과 출력
- [x] 최종 우승자 출력
## Controller
### GameController
- [ ] 게임 시작 기능
## Util
### RandomNumberGenerator
- [x] 랜덤 숫자 생성 기능
  - 0에서 9 사이의 정수
### InputValidator
- [x] 입력 숫자 유효성 검증 기능
- [ ] 자동차 이름 유효성 검증 기능
## Exception
- 이름이 중복된 경우
- 이름의 길이가 5보다 큰 경우
- 시도 횟수가 정수가 아닌 경우
- 시도 횟수가 1보다 작은 경우