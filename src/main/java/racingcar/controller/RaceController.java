package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Joiners;
import racingcar.domain.Player;
import racingcar.domain.response.PlayResult;
import racingcar.service.RaceService;
import racingcar.service.RandomNumberService;
import racingcar.validator.CarNamesValidator;
import racingcar.validator.TotalRoundValidator;
import racingcar.view.GuideMessagePrinter;

import static racingcar.view.GuideMessagePrinter.printFinalWinners;
import static racingcar.view.GuideMessagePrinter.printRaceResultGuildMessage;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 1:21
 */
public class RaceController {
    public void run() {
        String carNames = inputCarNames();
        int totalRound = inputTotalRound();

        Player player = Player.of(carNames, totalRound);
        Joiners joiners = Joiners.of(player);

        printRaceResultGuildMessage();
        RaceService raceService = new RaceService(new RandomNumberService());
        PlayResult playResult = raceService.play(joiners, player);
        printFinalWinners(playResult.getWinners());
    }

    private String inputCarNames() {
        GuideMessagePrinter.printInputCarNamesGuideMessage();
        String namesByComma = Console.readLine();
        while (!CarNamesValidator.isValidCarNames(namesByComma)) {
            GuideMessagePrinter.printInputCarNamesGuideMessage();
            namesByComma = Console.readLine();
        }
        return namesByComma;
    }

    private int inputTotalRound() {
        GuideMessagePrinter.printInputRoundCountGuideMessage();
        String totalRoundCount = Console.readLine();
        while (!TotalRoundValidator.isValidRoundNumber(totalRoundCount)){
            GuideMessagePrinter.printInputRoundCountGuideMessage();
            totalRoundCount = Console.readLine();
        }
        return Integer.parseInt(totalRoundCount);
    }
}
