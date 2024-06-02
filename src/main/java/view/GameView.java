package view;

public class GameView {
    public void initialCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void raceAttemps(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showCarsPositionInit(){
        System.out.println("실행결과");
    }
    public void showCarsPosition(String name, int postion){
        String dashes = "-".repeat(postion);
        System.out.println(name + " : " + dashes);
    }
    public void printBlank(){
        System.out.println();
    }
    public void showWinner(String name){
        System.out.println("최종 우승자 : " + name);
    }
}
