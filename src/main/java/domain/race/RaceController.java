package domain.race;

public class RaceController {

    public void startRace(String carList, int round) {

    }

    public boolean validationCarList(String carNames) {
        if (carNames.isEmpty()) return false;
        if (carNames.charAt(0) == ',') return false;
        if (carNames.charAt(carNames.length() - 1) == ',') return false;
        return true;
    }

    public boolean validationRound(int round) {
        if(round <= 0) return false;
        return true;
    }
}
