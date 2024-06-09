package view;

import controller.RacerController;
import dto.RacerDto;
import dto.RacerResult;
import entity.Racer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacerView {
    private final RacerController racerController;

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private List<String> nameList = null;

    private BigInteger tryCount = null;

    private RacerResult result = null;

    public RacerView(RacerController racerController) {
        this.racerController = racerController;
    }

    public void render() {

        if (nameList == null) {
            try {
                String input = getInput();

                nameList = Arrays.stream(input.split(","))
                        .map(this::validateName)
                        .toList();
            } catch (IllegalArgumentException e) {
                System.out.println(getFormattedErrorMessage(e.getMessage()));
                return;
            }
        }

        if (tryCount == null) {
            try {
                tryCount = getTryCount();
            } catch (IllegalArgumentException e) {
                System.out.println(getFormattedErrorMessage(e.getMessage()));
                return;
            }
        }

        racerController.setUp(nameList, tryCount);

        System.out.println("출력 결과");

        while (!racerController.isEnded()) {
            result = racerController.playGame();

            for (RacerDto racerDto : result.racerDtos()) {
                String distanceString = getDistanceString(racerDto);

                System.out.println(racerDto.name() + " : " + distanceString);
            }

            System.out.print("\n");
        }

        if (result != null) {
            String winners = result.racerDtos().stream()
                    .filter(RacerDto::isWinner)
                    .map(RacerDto::name)
                    .collect(Collectors.joining(", "));
            System.out.println("최종 우승자 : " + winners);
        }

        nameList = null;
        tryCount = null;
        result = null;
    }

    private String getDistanceString(RacerDto racerDto) {
        BigInteger movedDistance = racerDto.movedDistance();
        StringBuilder distanceStrBuilder = new StringBuilder();

        // BigInteger를 사용하여 반복문 구현
        for (BigInteger i = BigInteger.ZERO; i.compareTo(movedDistance) < 0; i = i.add(BigInteger.ONE)) {
            distanceStrBuilder.append('-');
        }

        return distanceStrBuilder.toString();
    }

    private String getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            return bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println(getFormattedErrorMessage("입력을 처리할 수 없습니다."));
            return null;
        }
    }

    private BigInteger getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        try {
            return new BigInteger(bufferedReader.readLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        } catch (Exception e) {
            System.out.println(getFormattedErrorMessage("입력을 처리할 수 없습니다."));
            return null;
        }
    }

    private String getFormattedErrorMessage(String errorMessage) {
        return "[ERROR] " + errorMessage;
    }

    private String validateName(String name) {
        if (name == null || name.isBlank() || name.trim().length() > Racer.NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }

        return name.trim();
    }
}
