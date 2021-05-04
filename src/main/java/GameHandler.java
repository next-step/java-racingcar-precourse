public class GameHandler {

    private CarList carList;

    public GameHandler() {
        carList = new CarList();
    }

    public void addCar(CarName carName) {
        carList.add(new Car(carName));
    }

    public void addCar(String carName) {
        String[] carNameList = carName.split(",");
        for (String car : carNameList) {
            carList.add(new Car(car));
        }
    }

    public String doRacing(int stepNum) {
        String result = "";
        for (int i=0; i < stepNum; i++) {
            carList.doStep();
            result += carList.toString();
        }
        return result;
    }

    public String getWinners() {
        Winner winner = new Winner(carList);
        return winner.getWinnerStr();
    }

}
