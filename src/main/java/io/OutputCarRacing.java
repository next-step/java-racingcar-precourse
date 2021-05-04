package io;

import domain.Car;
import domain.RacingPlayer;

import static util.CarRacingMessage.WINNER_INTRODUCE;

public class OutputCarRacing {

    public static void printTurn(RacingPlayer racingPlayer) {
        for (Car player : racingPlayer.getCarList()) {
            System.out.println(player.getCarName() + " : "
                    + appendPos(player.getPos()));
        }
        System.out.println();
    }

    public static String appendPos(int pos) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            buf.append("-");
        }
        return buf.toString();
    }

    public static void winnerPrint(RacingPlayer racingPlayer) {
        StringBuilder buf = new StringBuilder();
        for (String name : racingPlayer.whoIsWinner()) {
            buf.append(name + " ");
        }
        String ans = buf.toString().trim().replaceAll(" ", ", ");
        System.out.println(ans + WINNER_INTRODUCE);
    }
}
