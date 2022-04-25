package model;

import vo.CarVo;

public class WinnerModel {
    public void raceWinner(CarVo raceCar) {
        int winScore = 0;
        String winPrint = "";
        for(int i = 0; i < raceCar.getCarName().size(); i++) {
            winScore = getWinScore(raceCar.getCarScore().get(i), winScore);
        }
        for(int i = 0; i < raceCar.getCarName().size(); i++) {
            winPrint = selectWinner(winPrint, raceCar.getCarName().get(i), raceCar.getCarScore().get(i), winScore);
        }
        System.out.print("최종 우승자:" + winPrint);
    }

    private String selectWinner(String winPrint, String carName, int carScore, int winScore) {
        if(carScore == winScore) {
            return printWinner(winPrint, carName);
        }
        return winPrint;
    }

    private String printWinner(String winPrint, String carName) {
        if(winPrint.equals("")) {
            return carName;
        }
        return winPrint + ", " + carName;
    }

    private int getWinScore(int getScore, int winScore) {
        if(winScore < getScore) {
            return getScore;
        }
        return winScore;
    }
}
