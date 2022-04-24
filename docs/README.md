### 구현 할 기능 목록

1. Initial Commit
   - 테스트를 무조건 통과하도록 main()을 완성한다.
2. 입력을 두개를 받도록 한다.
3. 첫번째 입력은 이름이고, 이름의 길이는 5글자 초과하지 않도록 한다.
4. refactor: 사용자 입력을 Controller로 분리한다.
5. playerName과 Score를 묶어 ScoreMap(일급 컬렉션)으로 개념화 한다.

- scoreOne(), whoIsMax(), whoIsMin(),

6. ScoreMap 구현 보강

- 테스트 보강
- whoIsMax(), whoIsMin() 함수 구현하기

7. 기능 : 공동 우승자 처리를 위한 기능 구현 (우승자가 한명일 경우. 쉼표(,)로 이름을 구분해 출력한다.)

   1. ScoreMap의 whoIsMaxes() 함수 구현 (최고점을 복수형으로 반환)
   2. whoIsMax 반환값 인터페이스를 String -> String[]으로 변경
   3. 리팩터링 : View 메서드 리팩터링
   4. 테스트 : Game클래스에서 공동 우승자 선별하는 게임 테스트
   5. 리팩터링 : 불필요한 메서드 삭제

8. 기능 : 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고 "[ERROR]"로 시작하는 에러메시지를 출력후 그 부분부터 다시 입력을 받는다.

   1. 리팩터링 : 기능 구현 전에 코드 정리
   2. 기능 : 사용자가 잘못된 기능 입력한 경우 IllegalArgumentException 발생
   3. "ERROR"로 시작하는 에러 메시지 출력

9. 기능 : 에러 시도 횟수 표현하기

### Backlog

- refactor: 뷰쪽 메서드 쪼개기
- refactor: View쪽 반복되는 String.join() 하나로 합치기.
- Player와 Score를 더한 개념으로 추상화를 한번 더 하는게 좋을까? (PlayerScore)
