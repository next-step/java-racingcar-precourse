import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {
    Game game = new Game();
    @Test
    void makeCarsTest(){
        String str = "test1,test2,test3";
        String[] strArr = str.split(",");
        game.makeCars(str);
        ArrayList<Car> cars = game.getCars();
        boolean count = true;
        boolean name = true;
        for (int i = 0; i < 3; i++) {
            if(!strArr[i].equals(cars.get(i).getName()))
                name = false;
        }
        if(cars.size() != strArr.length)
            count = false;
        boolean tf = count && name;
        Assertions.assertTrue(tf);
    }

    @Test
    void racingTest(){
        String str = "test1,test2,test3";
        String[] strArr = str.split(",");
        game.makeCars(str);
        game.racing(5);
    }

    @Test
    void chooseWinnerTest(){
        String str = "test1,test2,test3";
        String[] strArr = str.split(",");
        game.makeCars(str);
        game.racing(5);
        String[] strings = game.chooseWinner();

        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = game.getCars().get(i).getRoute().length();
        }
        int max = Arrays.stream(arr).max().getAsInt();

        boolean tf = true;
        for (String string : strings) {
            if(string.length() != max)
                tf = false;
        }
        Assertions.assertTrue(tf);
    }
}
