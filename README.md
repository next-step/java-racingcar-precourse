# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

<hr>

## 기능목록

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출수있다.

* 사용자가 잘못된 값을 입력할 경우 “[ERROR]”로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.
* 사용자 입력(자동차 이름)
    * 쉼표(,)로 구분한다
    * 5글자 이하인가?
    * 아무값도 입력하지 않았는가?
    * 맨앞에 쉼표(,)로 시작하지 않는가?
    * 쉼표사이에 공백이 있지는 않는가?
* 사용자 입력(이동 횟수)
    * 숫자인가?
    * 음수인가?
    * 아무값도 입력하지 않았는가?
* 자동차
    * 0~9사이의 값이 들어왔는가?
    * 4이상일 경우 - 전진
    * 3이하일 경우 - 스탑
* 출력
    * 매횟수마다 자동차이름: 전진횟수(-) 표시
    * 입력한 횟수에 도달했는가?
    * 우승자가 한 명 이상인가?
        * 쉼표(,)로 이름을 구분해 출력한다.

<hr>

## 게임진행

`1. 경주할 자동차의 이름과 몇 변의 경주를 시도 할 것인지 입력합니다.`<br>
<img width="440" alt="게임플레이 화면" src="https://user-images.githubusercontent.com/46228593/136658372-1af32747-e7d1-493f-9db1-de9008212690.PNG"><br>
`2. 공동 우승자는 다음과 같이 출력됩니다.`<br>
<img width="220" alt="공동우승자" src="https://user-images.githubusercontent.com/46228593/136658426-8a7d63a5-2fa2-438c-b3aa-fb157e6b6617.PNG"><br>
`3. 잘못된 입력의 경우 재입력을 받습니다. 아래는 잘못된 입력에 대한 검증목록입니다.`<br>

```
[자동차 이름]
- 공백을 입력 할 경우
- 입력이 쉼표(,)로 시작할 경우
- 쉼표(,) 사이에 공백이 포함될 경우
[시도횟수]
- 공백을 입력 할 경우
- 입력이 숫자가 아닐 경우
```

<img width="440" alt="게임플레이화면(오류검증 포함 - 상세내용 설명)" src="https://user-images.githubusercontent.com/46228593/136658449-c80e8aed-f51d-4714-88d2-83f067d5390c.png"><br>

## 적용한점

### [TDD]

<img width="250" alt="TDD Cycle" src="https://user-images.githubusercontent.com/46228593/136663333-fb9adc03-831a-4949-916b-92bb1476d14f.PNG"><br>

```
모든 도메인에 TDD Cycle을 적용하여 개발하도록 노력하였습니다.
기능목록에 정의한 내용중 3이하의 값을 받으면 STOP 이라는 Car 기능을 예로들면 아래 그림과 같습니다.
```

`기능을 잘개 쪼개어 빨간불이 들어올 테스트를 만든 뒤 초록불로 바뀌도록 구현을 합니다.`<br>
<img width="400" alt="스탑테스트1" src="https://user-images.githubusercontent.com/46228593/136663644-957f31a8-d357-4a22-91f6-d850019483c8.PNG"><br>
<img width="190" alt="스탑테스트2" src="https://user-images.githubusercontent.com/46228593/136663649-97071293-f484-404c-a290-9fcff0e6a315.PNG"><br>

```
위에 작성한 STOP 테스트를 복사하여 GO로 조건만 바꾸어 보면 다시 빨간불이 들어오는 
걸 확인할 수 있습니다. 때문에 구현하였던 move()메소드를 초록불이 들어오도록 수정합니다. 
최종적으로 두테스트 모두 실행하여 모든 테스트가 초록불로 통과하는걸 확인합니다.
```

<img width="400" alt="스탑테스트3" src="https://user-images.githubusercontent.com/46228593/136663660-c4f1aa1f-2c6a-4805-bc79-66deb567c10d.PNG"><br>
<img width="190" alt="스탑테스트4" src="https://user-images.githubusercontent.com/46228593/136663671-422e3b3b-e214-4378-85e4-7152e95a4f77.PNG"><br>

### [직접 값을 꺼내지 않고 메시지를 전달하며 값을 얻어냄]

```
자동차의 상태가 GO인지 STOP인지 여부에 따라서 하이픈을 추가하는 기능이 있습니다. 아래 나쁜예 처럼 비교할 수도 있지만
isGo()라는 메서드를 만들어서 CarStatus에게 직접 본인의 상태를 물어보도록 하였습니다.
```

<img width="450" alt="메시지전달1" src="https://user-images.githubusercontent.com/46228593/136664449-d2ab6d6c-885f-45aa-bbbe-e151e4570ea8.PNG"><br>
<img width="180" alt="메시지전달2" src="https://user-images.githubusercontent.com/46228593/136664457-bcd0c7db-46e5-4069-becd-85951e912a17.PNG"><br>

### [원시값, 일급콜렉션 포장]

```
Car를 생성하기 위해서는 carName이 필요하고 5글자 이하여야 한다는 규칙이 있습니다.
하지만 아래 그림과 같이 되어있을때는 carName이 5글자 이하인지 알 수 없으며 별도의 검증을 해야합니다. 
```

<img width="290" alt="원시값 포장1" src="https://user-images.githubusercontent.com/46228593/136665005-2e198eae-71e5-4645-a30d-e0df054eac32.png"><br>

```
때문에 다음과 같이 carName을 포장한 CarName을 만들 수 있습니다. CarName 내부에서 5글자에 대한 검증이 이뤄지고 
Car는 이미 내부적으로 검증 된 값을 가지는 CarName을 신뢰할 수 있게됩니다.
```

<img width="300" alt="원시값 포장2" src="https://user-images.githubusercontent.com/46228593/136665007-901512bb-7897-42fb-acf0-10b7f4ec5e1c.PNG"><br>
<img width="600" alt="원시값 포장3" src="https://user-images.githubusercontent.com/46228593/136665008-3a4b2c9c-1c40-4973-a9ab-504a6e8cbda8.PNG"><br>

```
콜렉션 또한 동일하게 포장할 수 있습니다. 주의할 점은 원시값, 일급콜렉션 포장 둘다 내부에 필드로 원시값과
콜렉션만 가져야 한다는 점입니다.
```

<img width="350" alt="일급콜렉션 포장" src="https://user-images.githubusercontent.com/46228593/136665010-fa58e2d0-7c08-4bb0-8d5b-e53cef7f2d6b.PNG"><br>


