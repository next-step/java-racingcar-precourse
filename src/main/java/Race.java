import java.util.Random;

public class Race {
    public int randGen() {
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public boolean checkNum(int n) {
        return n >= 4;
    }

    public int checkGo(boolean b) {
        if (b) {
            return 1;
        }
        return 0;
    }

    public void updateCars(Car[] cars) {
        for (Car car : cars) {
            int r = randGen();
            boolean b = checkNum(r);
            int go = checkGo(b);
            car.setDistance(car.getDistance() + go);
        }
    }

    public void printCars(Car[] cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + car.toString());
        }
    }
}
