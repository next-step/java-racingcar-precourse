package view;


import java.util.List;
import model.Car;
import model.CarList;

public class PrintView {

    public void printStartView(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void printCountView(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printDriveView(int round, CarList carList){
        if( round == 0) {
            System.out.println("실행 결과");
        }
        for(Car car : carList.getCarList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinnerView(List<String> winnerList){

        StringBuilder winners = new StringBuilder();
        for (String winner : winnerList) {
            winners.append(winner).append(", ");
        }
        // 마지막 ", " 제거
        if (winners.length() > 0) {
            winners.setLength(winners.length() - 2);
        }
        System.out.println("최종 우승자 : " + winners.toString());
    }
}
