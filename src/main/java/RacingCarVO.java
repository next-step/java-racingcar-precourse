import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RacingCarVO {
    private int try_num;
    private int go_prob;
    private int car_size;
    private String[] cars;
    Map<String , Integer> race = new HashMap<>();


    public RacingCarVO() {
        this.try_num = 0;
        this.car_size = 0;
        this.go_prob=4;
    }// constructor


    public RacingCarVO(int try_num, int go_prob) {
        this.try_num = try_num;
        this.go_prob = go_prob;
    }// constructor overloading


    public void GetCar() {
        int tri = 0;
        String input;
        do {
            tri = 0;
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            cars = input.split(",");
            for (String car : cars) {
                tri += FindError(car);
            }
        } while (tri != 0);
    }// get carname


    public void AddCar() {
        for (String car : cars) {
            race.put(car,0);
        }
    } //get a carname


    public int FindError(String car) {
        try {
            if (car.length() > 5) {
                throw new IllegalArgumentException("car name must be less than 5 characters!");
            }
            return 0; // 올바른 입력이 들어올때
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] : %s is more than 5 characters!\n" , car);
        }
        return 1;
    } // find error.


    public void PrintCar(){
        for (String car : cars ){
            System.out.println(car + " " + race.get(car));
        }
    }// print all cars



}
