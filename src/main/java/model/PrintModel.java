package model;

import vo.CarVo;

public class PrintModel {
    public void raceResult(CarVo raceCar) {
        //갯수만큼 -출력
        for(int i = 0; i < raceCar.getCarName().size(); i++) {
            printRaceStatus(raceCar, i);
        }
        System.out.println();
    }

    private void printRaceStatus(CarVo raceCar, int i) {
        System.out.print(raceCar.getCarName().get(i) + " : ");
        for(int j = 0; j < raceCar.getCarScore().get(i); j++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
