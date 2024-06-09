# java-racingcar-precourse
***
## 패키지 구조
***
```
├── RacingGameApplication.java
├── config
│   └── constant
│       └── Rule.java
├── controller
│   └── RacingGameController.java
├── domain
│   ├── Car.java
│   └── Cars.java
├── exception
│   └── constant
│       └── ErrorMessage.java
├── util
│   └── RandomNumberGenerator.java
├── validator
│   ├── AttemptCountValidator.java
│   └── CarNameValidator.java
└── view
    ├── InputView.java
    ├── OutputView.java
    └── constant
        ├── InputMessage.java
        └── OutputMessage.java
```

### config 패키지
> 게임 설정과 관련된 파일이 위치합니다.  
* `Rule.java`
  * 레이싱 게임을 진행함에 있어 지켜야 할 규칙에 대해 상수로 정의합니다.

### controller 패키지
> Model과 View를 이어주는 Controller가 위치합니다.
* `RacingGameController.java`
  * 레이싱 게임을 진행하기 위한 컨트롤러

### domain 패키지
> 레이싱 게임을 구성하기 위한 도메인이 위치합니다.
* `Car.java`
  * 레이싱 게임에 참여하는 한 대의 자동차를 의미합니다.
  

* `Cars.java`
  * 레이싱 게임에 참여하는 자동차들의 집합을 의미합니다.
  * 자동차의 집합 중 승자를 판단할 수 있습니다.

### exception 패키지
> 레이싱 게임 진행 중 발생하는 예외에 대한 정보가 위치합니다.
* `ErrorMessage.java`
  * 게임 중 발생하는 예외 메시지에 대해 정의합니다.

### util 패키지
> 게임 진행에 필요한 유틸리티 클래스들이 위치합니다.
* `RandomNumberGenerator.java`
  * 자동차를 움직이기 위한 난수를 발생시킵니다.

### validator 패키지
> 게임에 사용되는 검증기가 위치합니다.
* `AttemptCountValidator.java`
  * 레이싱 실행 횟수에 대하여 검증합니다.
    * 입력값이 숫자가 맞는지 검증합니다.
    * 입력값이 양의 정수가 맞는지 검증합니다.   


* `CarNameValidator.java`
  * 자동차 이름에 대한 검증을 실시합니다.
    * 이름이 존재하는지 검증합니다.
    * 이름의 길이가 적절한지 검증합니다.
    * 이름에 빈 문자열이 있는지 검증합니다.
    * 이름 입력에 대해 중복이 존재하는지 검증합니다.

### view 패키지
> view 계층이 위치합니다.
* `InputView.java`
  * 입력에 필요한 내용을 출력합니다.
  * 적절한 입력이 발생할 때까지 사용자로부터 입력을 받습니다.


* `OutputView.java`
  * 게임의 결과에 대해 출력합니다.


* `InputMessage.java`
  * 입력에 필요한 메시지를 정의합니다.


* `OutputMessage.java`
  * 출력에 필요한 메시지를 정의합니다.