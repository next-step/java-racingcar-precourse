package racingCar.view;

import racingCar.domain.CarDTO;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String GAME_RESULT_MSG = "실행 결과";
    private static final String FINAL_WINNER_MSG = "최종 우승자 : ";

    /**
     * "실행 결과" 문자열을 출력하는 메서드
     */
    public static void printGameResultMessage() {
        System.out.print('\n' + GAME_RESULT_MSG);
    }

    /**
     * 각 라운드의 결과를 출력하는 메서드
     * @param carDTOList Car 객체 리스트
     */
    public static void printGameResult(List<CarDTO> carDTOList) {
        System.out.println();
        carDTOList.forEach(
                carDTO -> {
                    System.out.print(carDTO.getName() + " : ");
                    System.out.println("-".repeat(carDTO.getPos()));    // '-'를 pos 수만큼 반복
                }
        );
    }

    /**
     * 경주의 최종 승리자를 출력하는 메서드
     * @param winnerList 승리자 객체 리스트
     */
    public static void printFinalWinner(List<CarDTO> winnerList) {
        System.out.print('\n' + FINAL_WINNER_MSG);

        StringJoiner joiner = new StringJoiner(", ");
        winnerList.forEach(carDTO -> joiner.add(carDTO.getName()));
        System.out.println(joiner);
    }
}
