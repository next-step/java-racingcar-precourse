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
        race.GetTryNum(try_num);
        // get try_num and insert

        race.Try();
        // print all car and distace

        race.OnlyWinner();
        // remove except winner

        race.PrintWinner();
        // print all winner

    }
}
