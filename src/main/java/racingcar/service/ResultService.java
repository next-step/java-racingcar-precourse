package racingcar.service;

import javafx.util.Pair;
import racingcar.constant.Configuration;
import racingcar.constant.ViewMessage;
import racingcar.domain.Record;
import racingcar.domain.Result;

import java.util.List;

public class ResultService {
    private Result result;

    public ResultService(Result result) {
        this.result = result;
    }

    public void printResult() {
        System.out.println(Configuration.NEW_LINE + ViewMessage.GAME_RESULT);
        showRecordByRound();
        List<String> winners = result.pickFinalWinners();
        printWinner(winners);
    }

    private void showRecordByRound() {
        List<Record> recordList = result.getRecordList();
        recordList.forEach(record -> showResult(record));
    }

    private void showResult(Record record) {
        record.getRecordsByRound().forEach(car -> printDistanceByCar(car));
        System.out.println();
    }

    private void printDistanceByCar(Pair<String, Integer> recordByCar) {
        String distanceStr = "";
        for(int i = 0; i < recordByCar.getValue(); i++) {
            distanceStr += ViewMessage.DISTANCE_BAR;
        }
        System.out.println(recordByCar.getKey() + Configuration.NAME_COLON + distanceStr);
    }

    public void printWinner(List<String> winners) {
        System.out.print(ViewMessage.WINNER_LIST);
        System.out.println(String.join(Configuration.NAME_DELIMITER, winners));
    }
}
