package util;

import domain.RaceReport;
import dto.CarDto;

import java.util.ArrayList;
import java.util.List;

public class RaceReportFormatUtil {
    private static final String LOCATION_POINTER = "-";
    private static final String COLON = ":";
    private static final String LINE_OPEN = "\n";

    public static String format(RaceReport raceReport) {
        List<CarDto> cars = raceReport.getResults();
        StringBuilder stringBuilder = new StringBuilder();
        for (CarDto carDto : cars) {
            appendOneTurnReport(stringBuilder, carDto);
        }
        return stringBuilder.toString();
    }

    private static void appendOneTurnReport(StringBuilder stringBuilder, CarDto carDto) {
         stringBuilder.append(carDto.getName())
                 .append(COLON)
                 .append(new String(
                         new char[carDto.getLocation().getValue()]).replace("\0", LOCATION_POINTER))
                 .append(LINE_OPEN);
    }

    public static String formatWinners(RaceReport raceReport) {
        List<String> carNames = new ArrayList<>();
        for (CarDto winner : raceReport.findWinners()) {
            carNames.add(winner.getName());
        }
        return String.join(",", carNames);
    }
}
