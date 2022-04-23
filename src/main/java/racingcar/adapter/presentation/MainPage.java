package racingcar.adapter.presentation;

import java.util.List;
import racingcar.adapter.ephemeral.out.RacingCarAdapter;
import racingcar.application.port.in.CreateRacingCarCommand;
import racingcar.application.port.in.CreateRacingCarUsecase;
import racingcar.application.port.in.PlayRacingCommand;
import racingcar.application.port.in.PlayRacingUsecase;
import racingcar.application.service.CreateRacingCarService;
import racingcar.application.service.PlayRacingService;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;
import racingcar.domain.RoundResult;

public class MainPage implements Page {

    @Override
    public void execute() {

        RacingResult[] racingResult = new RacingResult[1];

        RacingCarAdapter racingCarAdapter = new RacingCarAdapter();
        new RacingCarConsole("경주할 자동차 이름을 입력하세요.(이름은 5자 이하만 가능하고 쉼표(,) 기준으로 구분)\n",
                "이름을 다시 입력해주세요(이름은 5자 이하만 가능하고 쉼표(,) 기준으로 구분)").execute(input -> {
            CreateRacingCarUsecase createRacingCarUsecase = new CreateRacingCarService(racingCarAdapter);
            createRacingCarUsecase.create(new CreateRacingCarCommand(input));
        });

        new RacingCarConsole("시도할 횟수\n", "시도 횟수는 0보다 큰 정수여야 한다.").execute(input -> {
            PlayRacingUsecase playRacingUsecase = new PlayRacingService(racingCarAdapter);
            racingResult[0] = playRacingUsecase.playRacing(new PlayRacingCommand(input));
        });

        System.out.print(getRoundResultMessage(racingResult[0]));
        System.out.print("최종 우승자: " + getWinnerMessage(racingResult[0]));

    }

    private String getRoundResultMessage(RacingResult racingResult) {
        StringBuilder sb = new StringBuilder();

        List<RoundResult> roundResultList = racingResult.getRoundResultList();

        for (RoundResult roundResult : roundResultList) {
            sb.append(roundResult.toString());
        }

        return sb.toString();
    }

    private String getWinnerMessage(RacingResult racingResult) {
        StringBuilder sb = new StringBuilder();
        List<RacingCar> winners = racingResult.getWinners();

        for (RacingCar car : winners) {
            sb.append(car.getRacingCarName().getName());
            sb.append(",");
        }

        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

}
