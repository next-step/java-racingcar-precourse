package racingcar;

import racingcar.model.Circuit;
import racingcar.service.RacingCarService;
import racingcar.ui.BasicView;
import racingcar.ui.TrackView;

public class Application {
    public static void main(String[] args) {
        // 필요한 서비스 생성및 초기화
        Circuit circuit = new Circuit();
        RacingCarService racingCarService = new RacingCarService(circuit);
        BasicView basicView = new BasicView(racingCarService);
        TrackView trackView = new TrackView(racingCarService);

        basicView.printRegisterCarListView();
        basicView.printRegisterTrialView();
        trackView.printTrack();
        trackView.printWinner();
    }
}
