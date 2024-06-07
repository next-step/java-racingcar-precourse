package view;

import java.util.List;
import service.CarServiceInterface;

public interface RaceViewInterface {

    public void userCarsInput();

    public void userRoundsInput();

    public void printProgress();

    public void printProcess();

    public void printResult(List<CarServiceInterface> winners);

    public void printCarsErrorMessage();

    public void printRoundsArgumentErrorMessage();

    public void printRoundsFormatErrorMessage();
}
