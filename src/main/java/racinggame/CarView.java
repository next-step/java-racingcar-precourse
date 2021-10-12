package racinggame;

public class CarView {

    public void startGame(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputGameSize(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void resultMsg(){
        System.out.println("실행결과");
    }

    public void winnerMsg(String winner){
        System.out.println("최종 우승자는 "+winner+" 입니다.");
    }

}
