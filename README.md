# java-racingcar-precourse

## 패키지 구조
src
└── main
├── java
│   └── racinggame
│       ├── Application.java                // 애플리케이션 시작점
│       ├── controller                      // 컨트롤러 패키지
│       │   └── RacingGame.java
│       ├── domain                          // 도메인 패키지
│       │   ├── Car.java
│           └── User.java                   
│       ├── validator                         // 검증 패키지
│       │   └── InputValidator.java
│       └── view                            // 뷰 패키지
│           ├── InputView.java
│           └── ResultView.java
└── test                                    // 테스트 패키지
└── java
└── racinggame
├── controller                  // 컨트롤러 테스트 패키지
│   └── RacingGameTest.java
├── domain                      // 도메인 테스트 패키지
│   └── CarTest.java
│   └── User.java   
├── validator                     // 검증 테스트 패키지
│   └── InputValidatorTest.java
└── view                        // 뷰 테스트 패키지
├── InputViewTest.java
└── ResultViewTest.java
