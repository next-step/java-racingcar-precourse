import java.util.List;

public class Printer {
    public static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputError(String localizedMessage) {
        System.out.println(localizedMessage + ". 다시 입력하세요.");
    }

    public static void printInputGameNumber() {
        System.out.println("시도할 회수는 몇회인가요? (1-20)");
    }

    public static void printTrackStatus(Track track) {
        List<Car> carList = track.getCarList();
        for (Car car : carList) {
            System.out.println(car.getName() + ":" + generatePositionDash(car));
        }
        System.out.println();
    }

    private static String generatePositionDash(Car car) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i=0;i<car.getPosition();i++) {
            stringBuffer.append("-");
        }
        return stringBuffer.toString();
    }

    public static void printRaceStart() {
        System.out.println("실행 결과");
    }
}
