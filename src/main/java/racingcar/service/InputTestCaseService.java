package racingcar.service;

import racingcar.value.TestCase;

public class InputTestCaseService implements InputService {

    private final TestCase testCase;

    public InputTestCaseService(TestCase testCase) {
        this.testCase = testCase;
    }

    @Override
    public String getCars() {
        return testCase.getCars();
    }

    @Override
    public String getTrack() {
        return testCase.getCount();
    }
}
