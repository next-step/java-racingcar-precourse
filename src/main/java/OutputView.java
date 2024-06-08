import java.util.List;
import model.Car;

public class OutputView {

    public void printRaceStartPrompt() {
        System.out.println("\n실행 결과");
    }
    public void PrintSetStatus(List<Car> cars) {
        for(Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.printf("%s : %s\n", car.getName(), getMoveString(car.getCurPosition()));
    }

    private String getMoveString(int curPosition) {
        String dashStack = "";
        for(int i = 0; i < curPosition; ++i) {
            dashStack += "-";
        }
        return dashStack;
    }

    public void printWinCars(String winners) {
        System.out.printf("최종 우승자 : %s", winners);
    }
}
