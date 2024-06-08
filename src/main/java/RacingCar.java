import java.util.List;
import java.util.Scanner;

public class RacingCar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> carNames = GetCarNames.getCarNames(scanner);
        int numberOfRounds = GetNumberOfRounds.getNumberOfRounds(scanner);
        List<Integer> pos = InitializePos.initializePos(carNames.size());

        PlayRace.playRace(carNames, numberOfRounds, pos);
        ShowWinners.showWinners(carNames, pos);

        scanner.close();
    }

}
