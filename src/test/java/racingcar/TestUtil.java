package racingcar;

import java.util.ArrayList;
import racingcar.GameView.ConsoleUtil;
import racingcar.RacingCar.RandomUtil;

public class TestUtil {
    static class FakeRandomUtil implements RandomUtil {
        Integer testNumber;

        FakeRandomUtil(Integer number) {
            testNumber = number;
        }

        @Override
        public int getNumberInRange(int startInclusive, int endInclusive) {
            return testNumber;
        }
    }

    static class FakeConsoleUtil implements ConsoleUtil {
        String input_string;
        boolean isFirst;

        FakeConsoleUtil(String test_string) {
            input_string = test_string;
            isFirst = true;
        }

        @Override
        public String readLine() {
            if (isFirst) {
                isFirst = false;
                return input_string;
            }
            return "0";
        }
    }

    static String parseCarName(String name_random) {
        String[] nameWithRandom = name_random.split(":");
        return nameWithRandom[0];
    }

    static int parseRandomValue(String name_random) {
        String[] nameWithRandom = name_random.split(":");
        return Integer.parseInt(nameWithRandom[1]);
    }

    static int parseDistance(String name_dist) {
        String[] nameWithDist = name_dist.split(":");
        return Integer.parseInt(nameWithDist[1]);
    }

    static RacingCarEntries makeRacingCarArrayListWithRandomValue(String[] carName_random_list) {
        ArrayList<RacingCar> car_list = new ArrayList<>();

        for (String name_random : carName_random_list) {
            String name = parseCarName(name_random);
            int random = parseRandomValue(name_random);
            RandomUtil fakeRandomUtil = new FakeRandomUtil(random);
            RacingCar car = new RacingCar(new CarName(name), fakeRandomUtil);

            car_list.add(car);
        }

        return new RacingCarEntries(car_list);
    }

    static RacingCar makeRacingCarMovedAs(String car_name, int step) {
        RacingCar car = new RacingCar(new CarName(car_name));

        for (int i = 0; i < step; ++i) {
            car.move();
        }

        return car;
    }

    static RacingCarEntries makeRacingCarArrayListWithFixedDistance(String[] carName_dist_list) {
        ArrayList<RacingCar> car_list = new ArrayList<>();

        for (String name_dist : carName_dist_list) {
            String name = parseCarName(name_dist);
            int dist = parseDistance(name_dist);
            RacingCar car = makeRacingCarMovedAs(name, dist);

            car_list.add(car);
        }

        return new RacingCarEntries(car_list);
    }
}
