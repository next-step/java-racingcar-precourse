public class RaceView {
    public void printPositions(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("\t");
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자: " + winners);
    }
}
