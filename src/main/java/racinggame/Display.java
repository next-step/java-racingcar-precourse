package racinggame;

public class Display {
    public static void enterName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void enterTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void executeText() {
        System.out.println("실행 결과");
    }

    public static void gameResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + gridHelper(car.getPosition()));
        }
        System.out.println();
    }

    public static String gridHelper(int count) {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += "-";
        }
        return str;
    }
}
