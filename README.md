# 🏎️ java-racingcar-precourse

- [Description](#description)
- [Functions(feature)](#functionsfeature)
  - [1. input racing car names](#1-input-racing-car-names)
  - [2. input number of attempts](#2-input-number-of-attempts)
  - [3. random number generation](#3-random-number-generation)
  - [4. determination of advancement](#4-determination-of-advancement)
  - [5. print racing process](#5-print-racing-process)
  - [6. determine winner](#6-determine-winner)
  - [7. print winner](#7-print-winner)
- [Exception](#exceptions)
  - [Racing car name list input exception](#racing-car-name-list-input-exception)
  - [Number of attempt input exception](#number-of-attempt-input-exception)

## Description
- 입력 받은 자동차들에 대해 랜덤으로 경주를 진행하고, 승자를 정하는 자동차 경주 게임

## Functions(feature)
- feature 단위로 작성
- branch 생성 시 `feature/function description` 형식으로 생성

### 1. input racing car names
- 경주할 자동차 이름들을 입력
- `경주할 자동차 이름을 입력하세요. 이름은 쉼표(,) 기준으로 구분)` 문구 출력 후 다음 줄에 한 줄로 입력 받기
    - 이때 쉼표 기준으로 구분하는 것에 유의
    - e.g. `test1,test2,test3`
- **입력 예외 처리**(예외 발생 시 프로그램 종료)
    - 자동차 이름의 길이가 1~5자가 아닌 경우
    - 자동차 이름이 1개 이하로 입력된 경우(쉼표 기준으로 구분)
    - 중복된 자동차 이름이 입력된 경우

### 2. input number of attempts
- 시도 횟수(0 이상의 정수)를 입력
- `시도할 회수는 몇회인가요?` 문구 출력 후 다음 줄에 입력 받기
- **입력 예외 처리**(예외 발생 시 프로그램 종료)
    - 정수가 아닌 입력이 들어온 경우
    - 0 이하의 입력이 들어온 경우

### 3. random number generation
- 0~9 사이의 무작위 값을 생성 후 반환

### 4. determination of advancement
- 전진 여부를 결정하고 이를 주행 거리에 반영
- random number를 바탕으로 전진하는 지 아닌 지 판단
    - 0~4 >> 정지
    - 5~9 >> 전진

### 5. print racing process
- 매 회차마다 실행된 결과를 출력
- 자동차 이름을 출력하고 각 자동차가 전진한 거리를 출력
    - e.g. `test : ---`
- 각 회차의 결과 간 줄 바꿈 출력

### 6. determine winner
- 전체 회차 종료 후 전진 거리가 가장 많은 사람을 우승자로 판별
- 이때 우승자는 여러 명일 수 있다.

### 7. print winner
- `최종 우승자 : ` 문구와 우승자를 출력
- 우승자는 여러 명일 수 있고, 다수일 경우 쉼표로 구분해 출력한다.
    - e.g. `최종 우승자 : test1, test2`

## Exceptions
- 잘못된 입력에 대해 `IllegalArgumentException` 발생
- 에러 메시지는 “[ERROR]”로 시작
- 에러 메시지 출력 후 해당 부분부터 다시 입력을 받는다.

### Racing car name list input exception
- `CarNameLengthException` : 각 자동차의 이름이 1~5자가 아닙니다.
- `CarCountLessThenTwoException` : 자동차가 2개 미만으로 입력되었습니다.
- `DuplicatedCarNameException` : 중복된 자동차 이름이 존재합니다.

### Number of attempt input exception
- `NonIntegerArgumentException` : 입력이 정수가 아닙니다.
- `AttemptBelowZeroException` : 입력이 0 이하입니다.