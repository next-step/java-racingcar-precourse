package racingcar.view;

import racingcar.model.car.CarDto;
import racingcar.model.game.BoardDto;

import java.util.List;

public class GameOutputScreen {

    public static void printErrorMessage(RuntimeException exception) {
        System.out.println(exception.getMessage());
    }

    public static void printRacingResult(BoardDto boardDto) {
        System.out.println("실행 결과");
        for (int i = 0; i < boardDto.getTryCount(); i++) {
            printRacingCarsRecord(boardDto.getEntrys(), i);
            System.out.println();
        }
    }

    private static void printRacingCarsRecord(List<CarDto> carDtos, int index) {
        for (CarDto carDto : carDtos) {
            System.out.print(carDto.getName().concat(" : "));
            printRacingCarMoveRecord(carDto.getMoveRecords(), index);
            System.out.println();
        }
    }

    private static void printRacingCarMoveRecord(List<Boolean> moveRecords, int index) {
        for (int i = 0; i <= index; i++) {
            printRacingCarMove(moveRecords.get(i));
        }
    }

    private static void printRacingCarMove(boolean isMove) {
        if (isMove)
            System.out.print("-");
    }

    public static void printWinners(BoardDto boardDto) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(",", boardDto.getWinners()));
    }


}
