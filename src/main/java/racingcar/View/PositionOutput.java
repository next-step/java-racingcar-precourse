package racingcar.View;

import racingcar.Position;

public class PositionOutput {
    public static void out(Position position){
        for (int i = 0; i < position.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
