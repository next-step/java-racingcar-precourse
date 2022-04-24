# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 사항

* docs/README.md를 확인바람

## 요구사항
* 자바는 8 버전으로 진행한다.
* JDK에서 제공하는 Random 및 Scanner API 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현한다.
* racinggame.ApplicationTest에 있는 2개의 Test Case가 성공해야 한다.
* 자바 코드 컨벤션을 준수한다.
* 커밋 컨벤션을 준수한다.
* 인덴트 제한은 1주차와 같이 2개의 들여쓰기
* stream API 사용 금지
* 메소드는 10줄 제한을 통해 메소드 및 클래스 분리를 고민해본다.
* else 사용 금지
* 일급 컬렉션 사용
* 원시값과 문자열은 포장해서 사용

## 디렉 토리 구성

#### @/racingcar/config

* ErrorMessage : 에러메시지 모음 enum class

#### @/racingcar/controller

* FrontController : PlayController라는 비즈니스 로직 서비스를 다루면서, 사용자가 입력해준 값 validation, typeContert 작업 수행
* PlayController : 싱글톤 객체로, Model을 주입받아 비즈니스 로직(게임 로직) 을 수행하는 컨트롤러

#### @/racingcar/model

* Car : 자동차 객체, 위치와 관련된 로직도 포함
* CarRepository : 싱글톤으로 관리하며, 경주에 참가하는 자동차를 저장하는 일급 컬렉션 객체, 생성자에서 자동차 리스트를 주입받고 추가로 자동차 주입 불가능
* Winner : 우승자를 가려내는 모델 객체

#### @/racingcar/resolver

* StringArgumentResolver : 싱글톤으로 관리하며, 사용자가 입력한 문자열 Input값을 확인하고, 타입 변경해주는 객체
* IntegerArgumentResolver : 싱글톤으로 관리하며, 사용자가 입력한 숫자 input 값을 validation 하고, 타입 변경해주는 객체
#### @/racingcar/utils

* 해당 디렉토리는 정적으로 사용할 함수들의 모음집으로 이름에서 각자의 역할을 확인할 수 있음

#### @/racingcar/view

* 화면과 관련한 기능 구현

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
