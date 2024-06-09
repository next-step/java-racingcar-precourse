import java.util.List;

public class GameView {
    public void requestCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestAttemptCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void requestMoveResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName()+" : ");
            for(int i=0; i<car.getPosition();i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    

    public void displayWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void displayErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }
}
