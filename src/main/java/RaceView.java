
public class RaceView {
    public void showSetcars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showSetiter() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showWinners(String output) {
        System.out.println("최종 우승자 : " + output);
    }

    public void showError(String output) {
        System.out.println("[ERROR] "+ output);
        System.out.println("다시 입력해주세요.");
    }
}