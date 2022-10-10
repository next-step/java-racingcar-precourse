package racingcar.controller;

import racingcar.model.RacingData;
import racingcar.view.RacingView;

public class RacingController {
    RacingData listup;
    public void setRacingCarLineUp(String list) {
        listup = new RacingData(list);
    }

    public void setTryNumber(String number) {
        listup.setTrys(number);
    }

    public void runRacing() {
        listup.setGoStops();
    }

    public void showRacingStatus() {
        RacingView.viewStatusRacing(listup);
    }

    public int getTryCount() {
        return listup.getTrys();
    }

    public void showWinners() {
        RacingView.viewWinners(listup.getWinners());
    }
}
