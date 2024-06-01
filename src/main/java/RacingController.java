public class RacingController {
    public static void createList(String[] carList) {
        for(String car: carList)
            RacingGame.racingCar.add(new Car(car));
    }
    public static void carVerify(String[] carList) {
        if (carList.length <= 1)
            throw new IllegalStateException();
        for (String c : carList)
            if (c.length() > 5 || c.isEmpty())
                throw new IllegalArgumentException();
        createList(carList);
    }
    public static int tryNumVerify(String n) {
        int number = Integer.parseInt(n);
        if(number < 1) {
            throw new IllegalArgumentException();
        }
        return number;
    }
    public static void racing() {
        for(Car car : RacingGame.racingCar)
            isForward(car);
    }
    public static void isForward(Car car) {
        if(RacingGame.randNum() >= 4)
            car.forward();
    }
}
