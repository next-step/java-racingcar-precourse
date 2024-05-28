import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
}
