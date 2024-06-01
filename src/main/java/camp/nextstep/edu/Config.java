package camp.nextstep.edu;

import camp.nextstep.edu.core.repository.RacingCarRepository;
import camp.nextstep.edu.core.repository.impl.InMemoryRacingCarRepository;
import camp.nextstep.edu.core.service.RacingCarService;
import camp.nextstep.edu.presenter.api.RacingCarApi;

public class Config {
    private static final RacingCarRepository racingCarRepository = new InMemoryRacingCarRepository();

    private static final RacingCarService racingCarService = new RacingCarService(racingCarRepository);

    private static final RacingCarApi racingCarApi = new RacingCarApi(racingCarService);

    public static RacingCarApi getRacingCarApi() {
        return racingCarApi;
    }
}
