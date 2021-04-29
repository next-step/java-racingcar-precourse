# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 하거나 멈출 수 있다.

* 각 자동차에 이름을 부여할 수 있다. 
* 전진하는 자동차 출력시 이름을 같이 출력
* 자동차 이름은 쉼표(,)를 기준으로 구분
* 이름은 5자 이하만 가능

* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 0에서 9 사이 random 값  
* randomNum >= 4  전진 
* randomNum <= 3  멈춤

* 게임을 완료한 후 누가 우승했는지를 알려준다. (한 명 이상 가능)

## 프로그래밍 요구사항 - 1주차 동일

* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - https://naver.github.io/hackday-conventions-java/
* indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
* 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
* else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

## 프로그래밍 요구사항 - 2주차 추가
* 일급콜렉션을 활용해 구현한다.
  https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
* 모든 원시값과 문자열을 포장한다.
  https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4

## 1차 FeedBack
**Product 코드를 짜고 싶은 욕망을 버려라**
* 실패하는 테스트 코드부터 만들기, 
    * 경계값들 설정
* 작은 단위로 만들기
    * 도메인 분리
    * 테스트하기 어려운 코드는 분리
* 도메인 분석 어려울 시 , 일단 구현
* 필드에 직접 접근하기 보다는 메세지를 보내라

## TODO List
* [ ] 도메인 분석 설계
* [ ] 도메인별 테스트
    * [ ] Accelerator 테스트
    * [ ] Car 테스트
    * [ ] Cars 테스트
    * [ ] RacingGame 테스트
* [ ] 이름 입력 받기
    * [ ] 쉼표 구분 받기
    * [ ] 유효성 검사
* [ ]
* [ ]

## 설계
* UI:
    * RacingGameApplication
        * Player를 가진다.
        * Stadium을 가진다.    
* Domain:
    * Accelerator
        * 값을 가진다.
        
        * 랜덤값을 생성할 수 있다.
        * 전진 여부를 전달 할 수 있다. (4이상)
    
    * Car
        * Accelerator를 가진다.
        * 각자의 이름 가진다.
        * 위치(이동거리) 가진다.
        
        * 전진 여부를 판단 할 수 있다.
        * 이름을 전달 할 수 있다.
        * 위치를 전달 할 수 있다.
        
    * Cars
        * Car를 가질 수 있다.
        * 총 진행 횟수를 가질 수 있다.
        * 현재 진행 횟수(상태)를 가질 수 있다.
        * 현재 우승자들을 가질 수 있다.
        
        * Car위치를 비교할 수 있다.(car? Cars?) 
    
    * Stadium  
        * 이름들을 요구 할 수 있다.
        * 횟수를 요구 할 수 있다.
        * Cars를 출발선에 세울 수 있다.(초기화)
        * 진행 횟수를 증가 시킬 수 있다.
        * 이름들을 가질 수 있다. 

    * Player 
        * 이름들을 입력 할 수 있다.
        * 횟수를 입력 할 수 있다.
        * 이름들을 전달 할 수 있다.(?)
        * 회수를 전달 할 수 있다. (?)
    
## 참고사항
* 과제제출방법 : <https://github.com/next-step/nextstep-docs/tree/master/precourse>
* 코드 컨벤션 : <https://naver.github.io/hackday-conventions-java/>   
* .gitattribute : <https://velog.io/@pks787/GitHub-CRLF-%EC%98%A4%EB%A5%98-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95>
* AssertJ Exception : <https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html>
* Parameterized Tests : <https://www.baeldung.com/parameterized-tests-junit-5>
* AssertJ 활용: <https://www.baeldung.com/introduction-to-assertj>
* commit message convention : <https://gist.github.com/stephenparish/9941e89d80e2bc58a153>
