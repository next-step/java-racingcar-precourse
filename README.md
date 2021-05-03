# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

자동차
- [x] 랜덤으로 숫자(0~9)를 만들고, 랜덤 숫자가 4이상이면 1칸 전진하는 기능
- [x] 자동차 이름 유효성 검증 기능

게임
- [x] 제일 많이 전진한 자동차를 추출하는 기능 (단, 제일 많이 전진한 자동차는 1개 이상일 수 있다)

User Interface
- [x] 쉼표(,)를 기준으로 다수의 자동차를 입력하는 기능
- [x] 자동차를 몇 번 이동할 것인지 입력하는 기능
- [x] 우승자를 출력하는 기능
- [x] 회차별로 사용자가 입력한 자동차의 이동 상황을 출력하는 기능

## 디자인

> 확장성과 테스트 용이성을 확보에 초점을 두고 디자인을 한 번 해봤습니다.
요구사항만을 디자인 했을 때 이 디자인이 과할 수는 있다고 생각하지만, 딱히 제한이 있지 않아서 도전해봤습니다!

![uml](https://github.com/momentjin/java-racingcar-precourse/blob/jaeeonjin/src/main/resources/uml.png?raw=true)

`Decorator 패턴`을 활용한 디자인이 기본 컨셉입니다.
- MovableObject : 레이싱 게임에서 움직이는 물체 종류를 뜻하며, Car, SuperCar 등이 있을 수 있습니다.
- MoveCondition : MovableObject가 앞으로 전진 할 때의 제약조건을 담고 있는 객체입니다.
- ConditionalMovableObject : MovableObject를 구현하지만, MovableObject의 동작을 확장하는 decorator 입니다.

참고) SuperCar는 임의의 객체입니다. 추가적인 요구사항이 생겼을 때를 가정해서 그려본 것 입니다.