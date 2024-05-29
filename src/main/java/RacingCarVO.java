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


    public int FindError(String car) {
        try {
            if (car.length() > 5) {
                throw new IllegalArgumentException(car + " is not allow");
            }
            return -1; // 올바른 입력이 들어오면 루프를 종료합니다.
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] : Car name must be less than 5 words");
        }
        return 0;
    } // find error. 






}
