public class AnswerPrinter {

    public void printEffect(Car[] racingCars) {
        for (int i = 0; i < racingCars.length; i++) {
            System.out.println(expressCarInfoToString(racingCars[i]));
        }
        System.out.println();
    }
    public StringBuilder expressCarInfoToString(Car car) {
        StringBuilder positionString = new StringBuilder();
        positionString.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            positionString.append("-");
        }
        return positionString;
    }
    public void printWinner(StringBuilder winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}