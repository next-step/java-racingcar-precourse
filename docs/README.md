* 자동차 경주 게임 구현

1. 0에서 9사이 Random 값 나오게
2. Random 값이 4이상이면 전진, 3이하면 멈춤
3. 자동차는 5자 이하의 이름, 주행거리를 가진다.
 1~5 글자가 아니면 IllegalArgumentException 발생
 주행거리가 음수이면 IllegalArgumentException 발생
4. n개의 자동차를 가지고, 주행거리를 기준으로 우승을 가릴 수 있다
5. 자동차 이름은 쉼표(,)를 기준으로 구분
6. 사용자 UI 구성
 사용자는 몇번의 이동을 할 것 인지를 입력
 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
 우승자가 한명 이상 일 경우,쉼표(,)로이름을 구분해 출력

(공통) 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,"[ERROR]"로 
       시작하는 에러메시지를 출력 후 그 부분부터 입력을 다시 받는다.
       Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
