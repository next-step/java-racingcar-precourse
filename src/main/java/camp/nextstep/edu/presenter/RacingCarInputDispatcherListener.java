package camp.nextstep.edu.presenter;

import camp.nextstep.edu.presenter.api.RacingCarApi;
import camp.nextstep.edu.presenter.dto.request.Request;

import java.util.Scanner;

public class RacingCarInputDispatcherListener {
    private final RacingCarApi racingCarApi;

    public RacingCarInputDispatcherListener(RacingCarApi racingCarApi) {
        this.racingCarApi = racingCarApi;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }



}
