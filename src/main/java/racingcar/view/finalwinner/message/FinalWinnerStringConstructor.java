package racingcar.view.finalwinner.message;

import racingcar.model.finalwinner.FinalWinnerName;
import racingcar.model.finalwinner.FinalWinnersOfGame;

import java.util.ArrayList;

public class FinalWinnerStringConstructor {
    private final FinalWinnersOfGame finalWinnersOfGame;

    public FinalWinnerStringConstructor(FinalWinnersOfGame finalWinnersOfGame) {
        this.finalWinnersOfGame = finalWinnersOfGame;
    }

    public String construct() {
        ArrayList<FinalWinnerName> finalWinnerNames = finalWinnersOfGame.getFinalWinnerNames();
        for (FinalWinnerName finalWinnerName : finalWinnerNames) {
            System.out.print(finalWinnerName.getName() + " ");
        }
        System.out.println("");
        StringBuilder finalWinnerNamesStringBuilder = new StringBuilder("최종 우승자 : ");
        finalWinnerNamesStringBuilder.append(finalWinnerNames.get(0).getName());
        for (int i = 1; i < finalWinnerNames.size(); ++i) {
            finalWinnerNamesStringBuilder.append(", ").append(finalWinnerNames.get(i).getName());
        }
        return finalWinnerNamesStringBuilder.toString();
    }
}
