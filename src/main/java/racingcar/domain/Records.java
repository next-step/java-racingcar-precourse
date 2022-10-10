package racingcar.domain;

import java.util.*;

public class Records {
    private final List<Record> recordList;

    private Records(List<Record> recordList) {
        this.recordList = recordList;
    }

    public static Records of(List<Record> recordList) {
        return new Records(recordList);
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public Winners getWinners() {
        Comparator<CurrentPosition> comparator = (s1, s2) -> s2.compareTo(s1.getValue());
        Map<CurrentPosition, List<String>> resultMap = new TreeMap<>(comparator);
        for (Record record : recordList) {
            putResultMap(resultMap, record);
        }
        List<String> winnerNames = resultMap.entrySet().iterator().next().getValue();
        return Winners.from(winnerNames);
    }

    private void putResultMap(Map<CurrentPosition, List<String>> result, Record record) {
        List<String> strings = result.get(record.getPosition());
        if (strings == null) {
            strings = new ArrayList<>();
        }
        strings.add(record.getName());
        result.put(record.getPosition(), strings);
    }
}
