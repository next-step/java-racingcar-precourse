package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarsInRace carsInRace = enterCarName();

        ProgressStep progressStep = enterProgressNumber();

        progress(carsInRace, progressStep);

        System.out.println("최종 우승자 : " + carsInRace.winnerString());
    }

    private static void progress(CarsInRace carsInRace, ProgressStep progressStep) {
        System.out.println("실행결과");
        for (int i = 0; i < progressStep.progressStopToInt(); i++) {
            carsInRace.allCarGoOrStop();
            System.out.println();
        }
    }

    private static ProgressStep enterProgressNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String progressNumberString = readLine();
        ProgressStep progressStep = new ProgressStep(new StepNumberString(progressNumberString));
        return progressStep;
    }

    private static CarsInRace enterCarName() {
        CarsInRace carsInRace = new CarsInRace();
        carsInRace.enterCarsName();
        return carsInRace;
    }
}
