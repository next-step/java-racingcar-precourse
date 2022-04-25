# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항 정의

- 자동차의 이름을 부여할 수 있다.
- 자동차의 이름을 부여할 때 쉼표를 기준으로만 부여할 수 있다.
- 자동차의 이름은 5자 이하여야만 한다.
- 시도할 횟수를 입력할 수 있다.
- 0 ~ 9사이의 랜덤값을 구할 수 있다.
- 랜덤값이 4 이상인 경우 전진할 수 있다.
- 랜덤값이 3 이하인 경우 멈추어야 한다.
- 시도 횟수가 모두 끝나면 자동차 경주 게임이 종료되어야 한다.
- 자동차 경주 게임이 종료되면 누가 우승했는지 알려주어야 한다.
- 우승자가 한 명 이상인 경우, 쉼표로 구분해서 출력해야 한다.
- 사용자가 잘못된 값을 입력할 경우, IllegalArgumentException 을 발생시켜야 한다.
- IllegalArgumentException 이 발생하면 "[ERROR]" 로 시작하는 메시지를 출력하여야 한다.
- IllegalArgumentException 이 발생되고 난 후 다시 입력을 받을 수 있어야 한다.
- Exception 이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리해야만 한다.

## 프로그래밍 요구사항

- JDK8 에서 동작할 것
- camp.nextstep.edu.missionutils 의 Randoms 및 Console API 사용
- ApplicationTest 는 반드시 통과
- 자바 코드 컨벤션
  - https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
- indent depth 는 1까지만 허용
- stream api 사용금지, 람다는 허용
- else 사용금지
- 메소드 길이 10줄 이내
- 일급콜렉션 활용
  - https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/
  - https://jojoldu.tistory.com/412
- 모든 원시값과 문자열 포장
  - https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4/
- 도메인 로직에 단위 테스트를 구현
  - MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한 단위 테스트에 집중
- 커밋 메시지 컨벤션 참고
  - https://gist.github.com/stephenparish/9941e89d80e2bc58a153