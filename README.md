# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구 사항

주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

## 기능 구현 목록 TODO-list

### Domain Models

#### Car

[X]  Client는, 5자 이하의 자동차 이름을 부여하여 자동차 개체를 생성할 수 있다.

- [X]  주어진 자동차 이름이 Null일경우, ERROR문구와 함께 IAE가 발생한다.
- [X]  주어진 자동차 이름이 Empty일경우, ERROR문구와 함께 IAE가 발생한다.
- [X]  주어진 자동차 이름이 5자 이상일경우, ERROR문구와 함께 IAE가 발생한다.

[x] Client는, 다음의 조건을 통해, 1대의 자동차를 한칸 전진 또는 멈출 수 있다.

- [X]  자동차 전진 조건 : [0..9] 사이의 random값을 구한 후, random값이 4이상일경우 전진, 3이하의 값이면 멈춘다.
- [X]  또한, 테스트를 위해 랜덤값을 생성하는 개체를 자동차 개체 생성시 입력 받을 수 있다.
- [X]  이때, random값이 [0..9] 사이가 아니면 ERROR문구와 함께 IAE가 발생한다.

[x] Client는, 원하는 전진 정책과, 전진 조건을 지정하여, 자동차 개체를 생성할 수 있다.

- [X]  주어진 전진 정책이 Null일경우, ERROR문구와 함께 IAE가 발생한다.
- [X]  주어진 전진 조건이 Null일경우, ERROR문구와 함께 IAE가 발생한다.

#### Cars (1급컬렉션)

[x] Client는, 주어진 자동차 이름들을 통해, 해당 이름이 주어진 자동차 개체들을 생성 할 수 있다.

- [X]  주어진 자동차 이름 리스트가 Null일경우, ERROR문구와 함께 IAE가 발생한다.
- [X]  주어진 자동차 이름 리스트가 Empty일경우, ERROR문구와 함께 IAE가 발생한다.
- [X]  주어진 자동차 이름 리스트 중, Null한 이름이 존재 할 경우, ERROR문구와 함께 IAE가 발생한다.
- [X]  주어진 자동차 이름 리스트 중, Empty한 이름이 존재 할 경우, ERROR문구와 함께 IAE가 발생한다.
- [X]  주어진 자동차 이름 리스트 중, 5글자 이상의 이름이 존재 할 경우, ERROR문구와 함께 IAE가 발생한다.

[x] Client는, 생성된 자동차 개체들을 모두 전진 또는 멈출 수 있다.

[x] Client는, 생성된 자동차 개체들이 모두 전진 또는 멈춘후, 가장 멀리 전진한 차들을 반환받을 수 있다.

### Contoller

[x] InputView로부터 입력 받은 이름들을 통해, 해당 이름의 자동차 개체 들을 생성 할 수 있다.

[x] InputView로부터 입력 받은 플레이 횟수만큼, 자동차 경주게임을 플레이 할 수 있다.

[x] 자동차경주게임가 끝나면, 가장 멀리 전진한 차들을 우승자로서 OutPutView에 전달 할 수 있다.

### View

#### InputView

[x] 사용자로부터, 경주 할 자동차 이름을, 쉼표 기준으로 입력받을 수 있다.

- [X]  이때, 사용자가 잘못된 값을 입력할 경우, IllegalArgumentException를 발생시키며, [ERROR]로 시작하는 에러메시지를 출력 할 수 있다.
- [X]  또한, 잘못된 부분부터 입력을 다시 받을 수 있다.

[x] 사용자로부터, 몇번의 이동을 시도 할 것인지 입력받을 수 있다.

- [X]  이때, 사용자가 잘못된 값을 입력할 경우, IllegalArgumentException를 발생시키며, [ERROR]로 시작하는 에러메시지를 출력 할 수 있다.
- [X]  또한, 잘못된 부분부터 입력을 다시 받을 수 있다.

#### OutputView

[x] 각 회수별, 각 자동차의 전진 실행 상태를 이름과 함께 출력할 수 있다.

[x] 자동차 경주 게임이 끝나면, 우승자를 출력할 수 있다.

- [X]  우승자가 다수 존재할경우, 쉼표로 이름 구분해 출력.

## Improvement

[x] Distance Value Object도입.

- 차가 가진 거리를 좀 더 명시적으로 표현 및 로직 중복 구현 방지.
- Position은 데카트르 좌표계를 가지는 의미로 해석될 수 있으니, 스칼라 값을 갖는 Distance값으로 표현

[x] 요구사항분석을 통한 자동차 개체 추상화.

- 자동차는, 전진 정책과, 전진 조건을 이용하여 전진 또는 멈출 수 있다.

[x] 개체생성과 이용분리를 위한 Factory개체 도입.

[] 적절한 커스텀 IAE Exceptions 생성.

## Decision Note

### 자동차 전진 정책과 전진 조건 개체 도입을 통한 추상화

#### ASIS

처음에는 단순히 랜덤 값을 생성자 인자로 받는 자동차 개체로 구현하였으나,

결국 랜덤 값을 통해 한 스텝만큼 전진 하는 개체가 너무 구체적인 요구사항에 묶여있다는 생각이 들었다.

#### TOBE

따라서 전진 정책과 조건의 추상화 및 제3자(ObjectFactory)에게 DI받는 식으로 구현하여, 구체적인 요구사항에 의존하지 않으며, OCP원칙을 따르는 디자인으로 구현을 개선했다.

#### 자동차 전진 정책과 전진 조건 개체 Injection은 왜 Constructor Injection을 사용하였는가?

Setter Injection을 사용하여, 상시 개체의 전진 정책과 조건을 바꿀 수 있도록 구현도 가능했지만, 다음과 같은 고려사항이 있었다

- null로 set되었을 때의 어떤 행동을 해야할지에 대한 결정이 필요해,
- 클라이언트 입장에서의 사용성과 코드 복잡성 증가

따라서, 개체 생성후는 항상 Valid한 상태로 유지하도록 Constructor Injection으로 결정하였다.

### 왜 Comparator를 Cars개체에서 생성하는가

Cars개체(Car 개체들을 가지고 있는 일급 컬렉션) 에서, 가장 멀리 전진한 자동차 개체를 찾아야 하는 로직 구현을 위해 다음과 같은 결정이 있었다.

#### ASIS:

구현방법:

- Comparable을 자동차 전진 거리를 나타내는 Distance 개체 및 Car 개체에서 구현
- Distance 개체의 Comparable: nature ordering (거리가 가까운 개체가 앞으로 오도록 구현)
- Car 개체의 Comparable: nature ordering (거리가 가까운 개체가 앞으로 오도록 구현)
- Cars 개체에서는 Car list를, 단순히 sort 및 reverse하여, list의 첫번째 Car개체가, 가장 멀리 전진한 개체로 판단

고려사항:

- Car 개체의 Comparable로직이 변경되면, silent하게 코드가 잘못 동작하게 될 가능성이 있다
- e.g, Car 게체가, 거리가 아닌, 이름순으로 nature ordering하게 되면, Cars 개체에서는 가장 멀리 전진한 거리가 아닌, 이름순이 가장 늦은 개체를 반환하게 된다.

#### TOBE:

방침:

- Car 개체의 sorting로직에 의존하지 않도록 한다

구현방법:

- 가장 멀리 전진한 자동차 개체를 찾아야 하는, Cars 개체에서, 직접 Comparator을 구현하여, 가장 멀리 전진한 Car 개체를 찾도록 한다

### 자동차의 전진 거리를 나타내는 개체 네이밍

Position은 데카트르 좌표계를 가지는 의미로 해석될 수 있으니, 스칼라 값을 갖는 Distance값으로 표현.

## NOTE (What I learned so far)

### Review : IAE vs ISE

- IAE : Invalid 인자값
- ISE : Invalid 타이밍에 메소드 호출

### Review : Role of @FunctionalInterface

- 궁금했던 점:

  - 해당 어노테이션 쓰지 않고도 람다를 이용해 사용가능한데, 굳이 어노테이션을 써야 하는 이유. 마커 어노테이션이라서?
- 목적:

  - 함수형 인터페이스 부합여부 확인 어노테이션
- How it works:

  - 둘 이상의 추상 메서드가 존재한다면, 컴파일시 오류 발생
  - static이나 default 선언이 붙은 메서드의 경우 추상메서드가 아니기에 카운트 하지 않는다

### Review : Condition of First Class Citizen

First Class Citizen 은 아래의 속성들을 모주 만족해야 한다.

1.변수에 값을 할당할 수 있어야 한다

2.메서드의 인자로로 넘겨줄 수 있어야 한다

3.메서드의 반환값이 될 수 있어야 한다

메서드는 위 조건의 모두를 만족하지 않으므로 일급객체가 아니지만, Functional Object를 이용하여 유사한 동작은 흉내 가능하다.

### Review : HashSet and TreeSet의 개체 비교방법

- HashSet: use equals
- TreeSet: use compareTo(@Comparable)

### Review : CompareTo() 동치성 규약

What?

- 필수는 아니지만, compareTo()의 동치성 조건은, equals() 규약과 맞추는게 좋다.

Why?

- 비교하는 컬렉션중, eqauls로 비교하는 컬렉션(e.g, HashSet. 아마 순서가 필요없으니)과, compareTo로 비교하는 컬렉션이 나눠져있기에(e.g, TreeSet)

### Question : Stream API Filter기능을 API쓰지않고, 1 depth로 작성하기

구현자체는 가능했지만, 과연 올바른 구현 방법인가에 대한 의문은 든다.

이유: addToListIfMatched(List, Item, Predicate)메서드에서, 인자로 받은 리스트에 아이템을 계속 추가시키는, 쉽게 말하면 상태를 계속 변경시키는 동작을 하기에, 리스트의 상태변화 추적이 어려울 것이라 생각된다.

```java
    private static <T> void addToListIfMatched(
        final List<T> list,
        final T item,
        final Predicate<T> predicate
    ) {
        if (predicate.test(item)) {
            list.add(item);
        }
    }

    private static <T> List<T> filter(final List<T> list, final Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T item : list) {
            addToListIfMatched(result, item, predicate);
        }
        return result;
    }

    public List<Car> getFarthestMovedCars() {
        final Car farthestMovedCar = getFarthestMovedCar();
        // Note : 자동차 개체 상태 변경 방지를 위해 immutable list 반환
        return Collections.unmodifiableList(filter(cars, farthestMovedCar::isSamelyMovedWith));
    }
```
