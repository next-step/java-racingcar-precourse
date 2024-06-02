import java.util.*;

public class RacingCarGame {
    private List<RacingCar> carList = new ArrayList<>();

    public void errorMessage(){
        throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
    }

    public boolean validName(String name){
        boolean state = true;
        if(name.length() <= 5) {
            carList.add(new RacingCar(name));
        }
        if(name.length() > 5) {
            state = false;
            errorMessage();
        }
        return state;
    }


}





