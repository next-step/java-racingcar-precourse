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
    }
    
}
