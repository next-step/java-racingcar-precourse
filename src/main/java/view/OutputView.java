package view;

import domain.RacingCar;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printRacingCarNameInputText(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printNumberOfTryInputTest(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printLine(){
        System.out.println();
    }

    public static void printErrorMessage(IllegalArgumentException exception){
        System.out.println(exception.getMessage());
    }

    public static void printGameStart(){
        System.out.println("실행 결과");
    }

    public static void printGameProgress(List<RacingCar> racingCars){
        racingCars.forEach(racingCar -> {
            System.out.print(racingCar.getName()+" : ");
            printGameProgressMove(racingCar.getMoveDistance());
        });
    }

    public static void printGameProgressMove(int count){
        for(int i=0; i<count; i++){
            System.out.print("-");
            if(i==count-1) printLine();
        }
    }

    public static void printWinners(List<RacingCar> winners){
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winners.size(); i++){
            System.out.print(winners.get(i).getName());
            if(i==winners.size()-1) break;
            System.out.print(", ");
        }
    }
}
