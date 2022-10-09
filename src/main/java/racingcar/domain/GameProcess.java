package racingcar.domain;

import java.util.List;

public class GameProcess {
    private final List<Cars> processes;

    public GameProcess(List<Cars> cars) {
        this.processes = cars;
    }

    public void saveProcess(Cars carsResult) {
        processes.add(carsResult);
    }

    public List<Cars> getProcesses() {
        return processes;
    }
}
