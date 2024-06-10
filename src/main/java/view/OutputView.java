package view;

import controller.res.CarInfoDto;
import domain.state.CarState;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_OUTPUT = "\n실행결과";
    private static final String WINNER_OUTPUT = "최종우승자 %s\n";
    public static void printError(String error){
        System.out.println(error + "\n");
    }

    public static void printResultOutput(){
        System.out.println(RESULT_OUTPUT);
    }

    public static void printStep(List<CarInfoDto> cars){
        for(CarInfoDto car : cars){
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printResult(List<CarInfoDto> cars){
        System.out.printf(WINNER_OUTPUT,
                cars.stream().map(CarInfoDto::getName)
                    .collect(Collectors.joining(", ")
                ));
    }
}
