import java.util.*;

public class RacingCarGame {
    private List<RacingCar> carList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int tryNum = 0;


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
    public boolean setCarNames(){;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = scanner.nextLine();
        String[] split = line.split(",");
        boolean state = true;
        for (String s : split) {
            try {
                state = validName(s);
            }
            catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                state = false;
                break;
            }
        }
        return state;
    }
    public boolean setTryNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        String line = scanner.nextLine();
        try {
            if(!(line != null && line.matches("[0-9]+"))) errorMessage();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
        tryNum = Integer.parseInt(line);
        return true;
    }


}





