# 자동차 경주 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 구현

1. Car - 사용자가 정의한 자동차의 정보를 가진 클래스
    - name - 이름을 저장하는 변수, String
    - progress - 이동한 정도를 저장하는 변수, StringBuffer
    - Car - 차량 이름을 전달받아 차량을 생성하는 생성자
    - getMoveProgress - 자동차 이동 상황을 반환하는 메소드
    - isPossibleToMove - Random 값을 통해 이동할 수 있는지 여부를 확인하는 메소드
    - move - 한 칸 이동하는 메소드

1. CarGroup - Car 객체들을 관리하는 클래스
    - cars - Car 객체를 저장하여 관리하는 Collection 클래스, List<Car>
    - CarGroup - 차량 이름을 배열로 전달받아 차량 그룹을 생성하는 생성자
    - moveCars - 자신이 관리하는 자동차를 이동시키는 메소드

1. ValidationChecker - 사용자 입력에 대한 정합성 체크를 수행하는 클래스
    - isValidTryCount - 사용자가 지정한 시도 횟수의 정합성을 체크

1. RaceGame 클래스 - 레이스 게임의 전체적인 흐름을 제어하는 클래스
    - getCarNames - 사용자가 입력한 차량들의 이름을 반환하는 메소드
    - getTryCount - 사용자의 시도 횟수를 입력받는 메소드
    - run - 게임 실행

1. Main 클래스 - application 동작을 위한 클래스
    - main - application 실행