# I/O Example

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong :
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

최종 우승자: pobi, honux
```

# 입출력 요구사항

- 입력은 경주할 자동차 이름으로 구분
  - `jang,won,ik` 이라면 3대의 자동차가 경주에 참여
- 우승자 문구
  - 단독 우승자
    - `최종 우승자: pobi`
  - 공동 우승자
    - `최종 우승자: pobi, jun`

# 예외 사항 에러 문구

- `[ERROR] 시도 횟수는 숫자여야 한다.`
