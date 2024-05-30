import java.util.Scanner;

public class RacingCar {
    public static void main(String[] args) {

        RacingCarVO race = new RacingCarVO();
        // create object
        race.GetCar();
        race.AddCar();
        //race.PrintCar();

        System.out.println("시도할 횟수는 몇회인가요?");
        Scanner scan = new Scanner(System.in);
        int try_num = scan.nextInt();
       // get try_num

        race = new RacingCarVO(try_num);
        //overloading







    }
}
