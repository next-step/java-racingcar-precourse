package racingcar;

import java.util.List;

public class CarRaceOutputController {

    public void printRoundResultTitle(){
        System.out.println("실행결과");
    }

    public void printRoundResult(Cars cars, CarResults carResults) {

        for(int i=0; i<cars.getCarCount(); ++i){
            System.out.println(makeCarResultOutput(cars.getIndexOfCar(i), carResults.getIndexOfResult(i)));
        }

        System.out.println();
    }

    private String makeCarResultOutput(Car car, CarResult carResult){
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName())
                .append(" : ");

        for(int i=0; i<carResult.getLocation(); ++i){
            sb.append("-");
        }

        return sb.toString();
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printWinner(List<String> winnerNameList) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ")
                .append(String.join(", ", winnerNameList));

        System.out.println(sb.toString());
    }
}
