import java.util.Scanner;

public class RaceView {
    Scanner scanner = new Scanner(System.in);
    public String showSetcars(){
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return scanner.nextLine();
    }

    public int showSetiter() {
        System.out.print("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void showWinners(String output) {
        System.out.print("최종 우승자 : " + output);
    }
}