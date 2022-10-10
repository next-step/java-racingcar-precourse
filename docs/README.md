# 프리코스 2주차 자동차경주게임

[![standard-readme compliant](https://img.shields.io/badge/readme%20style-standard-brightgreen.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)

우아한 테크 캠프 pro 프리코스 2주차 미션입니다. 

미션 목표는 1차에서 진행한 숫자야구게임 피드백과 추가 요구사항을 참고하여 자동차 경주게임을 완성하는 것입니다.

## Table of Contents

- [시작하기](#시작하기)
- [기능정의](#기능정의)
- [유의사항](#유의사항)
- [마감기한](#마감기한)

## 시작하기

- 시작점은 src/main/java의 racinggame.Application의 main()입니다.
- 자동차 경주 게임은 JDK 8 버전에서 실행됩니다.
```
$ java -version

openjdk version "1.8.0_292"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_292-b10)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.292-b10, mixed mode)
```
- 아래와 같이 테스트를 실행할 수 있습니다.
```
# Unix/Linux 계열
./gradlew clean test

# Windows 
gradlew.bat clean test
```

## 기능정의
이 Application은 아래와 같은 기능들이 구현되어 있습니다. 
각 기능 구현에 대한 Task 관리는 [이 링크](https://emadam.notion.site/798b9c9343684d48966b0d93c55a4a2a?v=35a284c688854c8f91abedefb9be3494)를 참고해주세요.

> - 사용자는 자동자 이름을 입력한다.
>     - 자동차는 쉼표로 구분해 여러대를 입력할 수 있다.
>     - 각 자동차의 이름의 길이가 5자를 초과할 경우 예외가 발생한다.
>     - 자동차 이름이 없으면 예외가 발생한다.
> - 사용자는 이동 횟수를 입력한다.
>     - 숫자가 아닌 값을 입력하면 예외가 발생한다.
>     - 음수를 입력하면 예외가 발생한다.
> - 사용자가 잘못된 값을 입력하면 [ERROR]로 시작하는 에러메세지를 출력한다.
>     - 에러가 발생하면 그 부분 부터 다시 입력을 받는다.
> - 자동차는 이동할 수 있다.
>     - 이동거리의 증가량이 음수면 예외가 발생한다
>     - 이동거리를 비교한다.
> - 각 라운드를 진행한다.
>     - 0~9 사이의 랜덤 숫자를 뽑는다.
>     - 0~9 사의의 숫자가 아니면 예외가 발생한다.
>     - 숫자가 4이상이면 전진한다.
>     - 진행상황을 확인한다.
>         - 이동거리를 프로그래스바로 변환시킨다.
>         - 자동차의 상태를 확인한다.
> - 가장 많이 전진한 자동차가 우승한다.
>     - 모든 라운드를 진행됐는지 확인한다
>     - 모든 라운드가 진행된 상태에서 라운드 진행시 예외가 발생한다.
>     - 우승한 자동차는 여러대라면 쉼표로 구분한다.

이 기능 정의 목록은 변경될 수 있습니다.

## 유의사항
코드 작성 시 아래와 같은 규칙을 지켜야 합니다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용합니다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용합니다.
- [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)을 지키면서 프로그래밍 해야합니다.
- 들여쓰기는 2depth를 넘지 않도록 합니다.
- stream API는 사용할 수 없습니다. 하지만 람다는 사용 가능합니다.
- else 예약어를 사용할 수 없습니다.
- 함수 및 메서드의 길이가 10라인을 넘어가지 않도록 합니다.
- [일급 콜렉션](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)을 활용합니다.
- 모든 [원시값과 문자열을 포장](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/)해야 합니다.
- Model에 대한 단위 테스트를 추가합니다. 
- [커밋 메세지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 commit log를 남깁니다.

## 마감기한
2022년 10월 10일(월) 23시 00분까지 Github에 PR을 등록하고 [우테캠 지원 플랫폼](https://apply.techcourse.co.kr/)에 과제 제출을 해야합니다.

과제 제출 방법은 [이 문서](https://github.com/next-step/nextstep-docs/tree/master/precourse)를 참고합니다.
