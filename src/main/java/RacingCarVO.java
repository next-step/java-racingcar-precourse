import java.util.HashMap;
import java.util.Map;

public class RacingCarVO {
    private int try_num;
    private int go_prob;
    private int car_size;
    Map<String , Integer> race = new HashMap<>();

    public RacingCarVO(int try_num, int car_size) {
        this.try_num = try_num;
        this.car_size = car_size;
    }// constructor 


}
