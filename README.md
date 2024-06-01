# java-racingcar-precourse

# 1.  RacingCarVO 클래스 생성
- <멤버변수>
 - private int try_num : 사용자에게 입력받은 시도횟수
 - private String[] cars: ,를 기준으로 파싱한 자동차 이름
- private int winner=0 : 승리자들이 이동한 거리
- Map<String , Integer> race = new HashMap<>() : 각각의 자동차 이름과
 자동차들이 이동한 거리

# 2.  GetCar()
자동차 이름입력받음 이때 오류인지 판단해서
오류면 오류메시지 출력하고 다시 입력받게 함

# 3.  GetCar(String input)
RacingCarTest에서 테스트코드를 작성할때
사용자의 입력값을 인자로 전달하기 위해
오버로딩을 이용했다.

# 4.  AddCar()
입력받은 자동차 이름과 이동거리를 0으로
초기화 시킨다.

# 5.  ErrorList1(String car) & FindError1(String car)
입력받은 글자가 5글자 초과 , 또는 비었을때 오류체크

# 6.  ErrorList2(String car , List Error_car) & FindError2(String car)
입력받은 글자 중간에 띄어쓰기가 있을때 , 또는 중복된 이름을 입력받았을때 오류체크

# 7.  Go() & GoOrStop() & Try()
GoOrStop 메서드안에 난수를 기준으로 GO 인지 STOP인지
판단하고 GO에 전달해주면 그거에따라서 거리를 +1 할지 +0 할지 결정
그걸 Try()메서드에서 사용자가 입력한 시도횟수만큼 반복

# 8. PrintCar()
매번 시도회차마다 자동차들의 거리만큼 - 기호 출력

# 9. GetWinner() 
이동거리 최대를 구해서 그 거리를 winner에 저장해줌

# 10. GetWinner(String[] cars ,Map<String, Integer> race )
RacingCarTest에서 테스트하기 위해서 자동차 이름인 Cars와
자동차이름과 거리가 담겨있는 race를 인자로 입력하고
winner를 반환함.

# 11. OnlyWinner()
승리자를 제외하고 나머지는 제거

# 12. PrintWinner()
승리자를 출력하는데 1명이면 쉼표를 표시하지 않고
2명 이상이면 쉼표로 구분함.

# 12. PrintWinner(Map<String, Integer> race )
RacingCarTest에서 테스트하기위해서 오버로딩 했다.
콘솔창에 출력된는 문자열을 반환해준다.



<br><br><br>
# - 후기
이번 과제는 이제 툴이나 깃이 어느정도 적응이 되어서 코드에 의도를 담으려고 노력했다.
<br> 이 코드의 의도는 최대한 main메서드에 담긴코드를 최소화 하자 였다.
<br> VO모델에 모든 실행을 위한 코드를 작성하고 main에서 그냥 호출만 해서
사용하도록 노력했다.
<br>개인적인 생각으로 객체지향언어인 만큼 사용자가 작성해야할 코드나 수정할 부분이
적어야 유지나 보수가 편할것 같다고 생각했다. 그래서 이런 의도를 적용해 보았다.
<br>리스트를 메서드 내에서만 쓰고 반환하는 형식으로 하는것 보다 아예 멤버변수로 만들어 버리면
어느 메서드에서도 접근이 가능해서 그렇게 코드를 작성해 보았다.
<br>코드를 작성할때 이제는 뭐가 더 효율적일지 한번더 생각해보고 있다.
<br> 이러한 과정으로 더 성장했으면 좋겠다.







