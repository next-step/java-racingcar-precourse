package domain.race;

public class RaceController {

    public boolean startRace(String carNames, int round) {
        try{
            if(!validationCarNames(carNames)){
                throw new IllegalArgumentException("자동차 이름이 잘못 입력되었습니다. 다시 입력해 주세요.");
            }
            if(!validationRound(round)){
                throw new IllegalArgumentException("라운드가 잘못 입력되었습니다.. 다시 입력해 주세요.");
            }
            // race 시작
        }catch (IllegalArgumentException exception){
            System.out.println("[ERROR] "+ exception.getMessage());
            return false;
        }
        return true;
    }

    public boolean validationCarNames(String carNames) {
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
