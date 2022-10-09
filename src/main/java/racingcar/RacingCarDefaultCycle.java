package racingcar;

import racingcar.context.ConsolePrinter;
import racingcar.context.ConsoleScanner;
import racingcar.context.RacingCarCycle;
import racingcar.domain.car.Cars;
import racingcar.domain.move.Move;
import racingcar.domain.move.TryCount;
import racingcar.domain.winner.Winner;
import racingcar.message.RacingCarMessagePort;
import racingcar.message.RacingCarMessagePortAware;
import racingcar.util.RandomGenerator;

public class RacingCarDefaultCycle
    implements RacingCarCycle, RacingCarMessagePortAware {

    private final Move move = new Move(RandomGenerator.get());

    private RacingCarMessagePort messagePort = null;
    private Cars cars = null;
    private TryCount tryCount = null;

    @Override
    public void onCars() {
        while (cars == null) {
            getCars();
        }
    }

    private void getCars() {
        try {
            cars = getPort().getCars();
        }
        catch (Exception e) {
            getPort().error(e.getMessage());

            // FIXME : 해당 코드 삭제하고 while 문으로 접근하게 할 경우 테스트 케이스 통과 못함, 확인 필요
            cars = getPort().getCars();
        }
    }

    @Override
    public void onTryCount() {
        while (tryCount == null) {
            getTryCount();
        }
    }

    private void getTryCount() {
        try {
            tryCount = getPort().getTry();
        }
        catch (Exception e) {
            getPort().error(e.getMessage());

            // FIXME : 해당 코드 삭제하고 while 문으로 접근하게 할 경우 테스트 케이스 통과 못함, 확인 필요
            tryCount = getPort().getTry();
        }
    }

    @Override
    public void onPlay() {
        while (tryCount.letsTry()) {
            cars.move(move);
            getPort().play(cars);
        }
    }

    @Override
    public void onFinish() {
        Winner winner = new Winner(cars);
        getPort().finish(winner);
    }

    @Override
    public RacingCarMessagePort getPort() {
        if (messagePort == null) {
            messagePort = new RacingCarMessagePort(
                new ConsolePrinter(),
                new ConsoleScanner()
            );
        }
        return messagePort;
    }
}
