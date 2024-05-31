import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RacingCarVO {
    private int try_num;
    private String[] cars;
    private int winner=0;
    Map<String , Integer> race = new HashMap<>();
    // set member variable

    public RacingCarVO() {
        this.try_num = 0;
    }// constructor


    public void GetTryNum(int try_num) {
        this.try_num = try_num;
    }// get try_num


    public void GetCar() {
        int tri = 0;
        String input;
        do {
            tri = 0;
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            cars = input.split(",");
            for (String car : cars) {
                tri += FindError1(car);
                tri += FindError2(car);
            }
        } while (tri != 0);
    }// get carname


    public void AddCar() {
        for (String car : cars) {
            race.put(car,0);
        }
    } //get a carname



    public int ErrorList1(String car) {
        if (car.length() > 5) {
            return 1;
        }
        if (car.isEmpty()) {
            return 2;
        }
        return 0;
    } //error list1


    List Error_car = new ArrayList();
    public int ErrorList2(String car , List Error_car){
        if (car.contains(" ")){
            return 3;
        }
        if (Error_car.contains(car)){
            return 4;
        }
        Error_car.add(car);
        return 0;
    }// error list2


    public int FindError1(String car) {
        try {
            if (ErrorList1(car) > 0) {
                throw new IllegalArgumentException("Car Name is no permmit");
            }
            return 0; // 올바른 입력이 들어올때
        } catch (IllegalArgumentException e) {
            if (ErrorList1(car) ==1) {
                System.out.printf("[ERROR] : %s is more than 5 characters!\n", car);
            }
            if (ErrorList1(car) ==2) {
                System.out.println("[ERROR] :You have to enter one more character!");
            } Error_car.clear();
        } return 1;
    } // find error in error list1


    public int FindError2(String car) {
        try {
            if (ErrorList2(car , Error_car) > 0) {
                throw new IllegalArgumentException("Car Name is no permmit");
            }
            return 0; // 올바른 입력이 들어올때
        } catch (IllegalArgumentException e) {
            if (ErrorList2(car , Error_car) ==3) {
                System.out.println("[ERROR] :Blank is not permmit!");
            }
            if (ErrorList2(car , Error_car) ==4) {
                System.out.println("[ERROR] :Duplicate is not permmit!");
            } Error_car.clear();
        } return 1;
    } // find error in error list 2


    public void Go(){
        for (String car : cars){
            int distance = race.get(car);
            distance += GoOrStop();
            race.put(car , distance);
        }
    }// Go and Stop and calculate distance


    public int GoOrStop() {
        Random rand = new Random();
        int tmp = rand.nextInt(10);
        if (tmp >=4) {
            return 1;
        }
        return 0;
    }// if tmp is more than 4 , go one step or stop


    public void Try(){
        for (int i=0; i<try_num; i++){
            Go();
            PrintCar();
        }
    } //shows the progress of the game


    public void PrintCar(){
        for (String car : cars ){
            String road = "-".repeat(race.get(car));
            System.out.println(car + " : " +road);
        }
        System.out.println(" ");
    }// print all cars and road for distace


    public int GetWinner(){
        int max=race.get(cars[0]);
        for (String car : cars ){
            if(max < race.get(car)) {
                max = race.get(car);
                winner++;
            }
        }
        return max;
    } // find winner distace


    public void OnlyWinner() {
        int max = GetWinner();
        for (String car : cars ){
            if(max != race.get(car)) {
                race.remove(car);
            }
        }
    } // remove except winner

    public void PrintWinner() {
        int i= race.size();
        System.out.print("최종 우승자 : ");
        for (String winner : race.keySet()){
            System.out.print(winner+" ");
            if (i >1 ){
                System.out.print(",");
            }
            i--;
        }
    }// show winner
}