package io;

import domain.Car;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public void printRace(String carName, int progress){
        String progressBar = "-".repeat(progress);
        System.out.println(carName + " : " + progressBar);
    }

    public void printWinner(List<Car> winner){
        String winnerNames = winner.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void print(String any){
        System.out.println(any);
    }
}

