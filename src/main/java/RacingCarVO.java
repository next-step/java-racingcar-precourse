import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RacingCarVO {
    private int try_num;
    private int go_prob;
    private int car_size;
    Map<String , Integer> race = new HashMap<>();

    public RacingCarVO(int try_num, int car_size) {
        this.try_num = try_num;
        this.car_size = car_size;
        this.go_prob=4;
    }// constructor


    public RacingCarVO(int try_num, int go_prob, int car_size) {
        this.try_num = try_num;
        this.go_prob = go_prob;
        this.car_size = car_size;
    }// constructor overloading


    public int GetCar(String car) {
        int n=0;
        race.put(car, 0);
        return n;
    } //get a carname






}
