import java.util.*;

public class RacingCarGame {
    private List<RacingCar> carList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int tryNum = 0;
    private Random rand = new Random();


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

    public void randomMove(int index){
        int randNum = rand.nextInt(9);
        if(randNum >= 4){
            carList.get(index).move();
        }
    }

    public void printResult(){
        int num = 0;
        for (RacingCar racingCar : carList) {
            num = racingCar.getNow();
            System.out.print(racingCar.getName() + " : ");
            for (int i=0; i<num; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void racingStart(){
        System.out.println("실행 결과");
        int n = carList.size();
        for(int i=0; i<tryNum; i++){
            for (int j=0; j<n; j++) {
                randomMove(j);
            }
            printResult();
        }
    }

    public List<String> findWinner(){
        int n = carList.size();
        List<String> winners = new ArrayList<>();
        Collections.sort(carList);
        Integer max = carList.get(0).getNow();
        winners.add(carList.get(0).getName());
        for(int i=1; i<n; i++){
            if(carList.get(i).now == max){
                winners.add(carList.get(i).getName());
            }
        }
        return winners;
    }

    public void printWinner(List<String> winners){
        System.out.print("최종 우승자 : ");
        int n = winners.size();
        System.out.print(winners.get(0));
        for(int i=1; i<n; i++){
            System.out.print(", ");
            System.out.print(winners.get(i));
        }
    }
}





