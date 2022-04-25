package controller;

import model.CarRaceModel;
import model.InputModel;
import model.PrintModel;
import model.WinnerModel;
import vo.CarVo;

import java.util.Map;
import java.util.HashMap;

public class RaceController {
    public void CarRaceStart () {
        CarVo carVo = new CarVo();
        carVo = InputModel.getInputCar(carVo);
        PrintModel printModel = new PrintModel();
        int inputRace = InputModel.getInputRace();
        for(int i = 0;  i < inputRace; i++) {
            carVo = CarRaceModel.RaceCar(carVo);
            printModel.raceResult(carVo);
        }
        WinnerModel winnerModel = new WinnerModel();
        winnerModel.raceWinner(carVo);
    }
}
