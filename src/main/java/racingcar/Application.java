package racingcar;

import racingcar.controller.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new GameController(new Scanner(System.in)).run();
    }
}