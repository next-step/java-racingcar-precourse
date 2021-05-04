public class Winner {

    private CarList carList;

    public Winner(CarList carList) {
        this.carList = carList;
    }

    public String getWinnerStr() {
        String result = "";
        int winnerProgress = getMaxProgress();
        for (int i = 0; i < carList.size(); i++) {
            result += getWinner(carList.get(i), winnerProgress);
        }
        result = result.replaceAll(",$", "");
        return result;
    }

    public int getMaxProgress() {
        int result = 0;
        for (int i = 0; i < carList.size(); i++) {
            result = Math.max(result, carList.get(i).getProgress());
        }
        return result;
    }

    public String getWinner(Car car, int winnerProgress) {
        if (car.getProgress() == winnerProgress) {
            return car.getCarNameStr() + ",";
        }
        return "";
    }

}
