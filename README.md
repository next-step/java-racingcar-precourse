# java-racingcar-precourse
## 패키지 구조
- View
- Controller
- Service
- Domain
- Repository
- Validator
- Utils

## 기능 명세
- [X] View: 자동차 이름을 입력 기능
- [X] View: 시도할 횟수 입력 기능
- [X] View: 매 횟수마다 경주 진행 상황 출력 기능
- [X] View: 최종 우승자 출력 기능
- [X] Controller: 경주의 전반적인 프로세스를 진행하는 기능
- [X] Domain: Car 객체를 생성하기 위한 DTO 정의 및 생성
- [X] Repository: 생성된 Car 객체들을 저장할 repository 정의 및 생성
- [X] Service: 입력된 이름에 맞는 Car 객체들을 생성하여 repository에 저장
- [X] Service: 자동차의 행동을 결정할 난수를 생성
- [X] Service: 자동차 전진, 정지 기능
- [X] Validation: 입력된 자동차 이름 유효성 검증
- [x] Validation: 입력된 반복 횟수에 대한 유효성 검증
