package controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Service {

    private Random random = new Random();

    public List<Integer> generatePercent(Integer carLength) {
        return random.ints(carLength, 0, 10)
                .boxed()
                .collect(Collectors.toList());
    }
}
