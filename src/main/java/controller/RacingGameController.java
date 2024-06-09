package controller;

import domain.state.CarState;
import java.util.List;
import java.util.stream.Collectors;
import service.RacingGameService;

public class RacingGameController {
    private final RacingGameService racingGameService;


    public RacingGameController() {
        this.racingGameService = new RacingGameService();
    }

    public void runGame(){
        //Todo Input값 받기
        var carName = List.of("Car1", "Car2", "Car3");
        var gameCount = 3;
        racingGameService.trackInit(carName);

        for(int i = 0; i < gameCount; i++){
            racingGameService.runStep();
            var cars = racingGameService.getCars();
            //Todo DTO변환 후 View에 값 반환하기
            for(CarState car : cars){
                System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
        //Todo DTO변환 후 View에 값 반환하기
        System.out.printf("최종 우승자 : %s\n", racingGameService.getWinners()
                .stream()
                .map(CarState::getName).
                collect(Collectors.joining(", ")));
    }
}
