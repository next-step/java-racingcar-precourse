# java-racingcar-precourse

# 기능 명세서
## inputValue()
- 경주할 자동차의 이름을 쉼표로 구분하여 입력받는다.
- 경주할 자동차의 개수만큼 객체 배열을 생성한다.
- 경기를 시도할 회수를 입력받는다.

## doRacing()
- 경기를 시작한다.
- 입력받은 경기 횟수동안 for문을 반복하며 경기를 진행한다.

## randGen()
- 0~9 사이의 난수를 생성한다.

## checkNum(int n)
- 생성된 난수를 확인하여 4이상이라면 true를 return하고 아니라면 false를 return한다.

## checkGo(boolean b)
- checkNum으로 확인한 boolean 변수를 통해 전진할지 전진하지 않을지를 결정한다.
- 전진을 결정했다면, "-"를 return하고, 아니라면 ""을 return한다.

## checkWin(Car[] c)
- 객체 배열을 입력받아 최종 우승자가 누구인지 확인한다.
- 만약 우스앚가 여려명일 경우, 쉼표를 통해 구분한다.
- return 값은 String으로 반환한다. 