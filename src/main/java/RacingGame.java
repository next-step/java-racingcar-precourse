import java.util.*;

public class RacingGame {
    private Scanner scn = new Scanner(System.in);
    public RacingGame(){ }

    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.playRacingGame();
    }

    /**
     * 전체 게임을 수행
     */
    public void playRacingGame(){
        List<RacingCar> cars = null;
        String names;
        int rounds;
        while(cars==null) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 / 이름은 5자 이하)");
            names = scn.next();
            cars = splitString(names);
        }
        System.out.println("시도할 횟수는 몇 회 인가요?");
        rounds = scn.nextInt();
        System.out.println("\n실행 결과");
        for(int i=0; i<rounds ; i++){
            playOneRound(cars);
        }
        List<RacingCar> res = getWinners(cars);
        printResult(res);
    }

    /**
     * 한 회차의 각 자동차를 전진 또는 정지 시키고 그 결과를 출력
     * @param cars
     */
    public void playOneRound(List<RacingCar> cars) {
        for (RacingCar car: cars) {
            car.playOneRound();
            car.printCurrentCount();
        }
        System.out.println();
    }

    /**
     * 전체 자동차 리스트를 받아, 전진 횟수가 최대인 자동차 리스트를 반환
     * @param cars 전체 자동차 리스트
     * @return 전진 횟수가 최대인 자동차 리스트
     */
    public List<RacingCar> getWinners(List<RacingCar> cars) {
        List<RacingCar> res = new ArrayList<>();
        PriorityQueue<RacingCar> car_queue = new PriorityQueue<>();
        for (RacingCar car : cars) {
            car_queue.add(car);
        }
        res.add(car_queue.poll());
        RacingCar temp_car;
        while(!car_queue.isEmpty() && (temp_car=car_queue.poll()).getCount()==res.get(0).getCount() )
            res.add(temp_car);

        return res;
    }

    /**
     * 최종 우승자 리스트를 받아서 결과를 출력
     * @param winners 최종 우승자 리스트
     * @return 결과 문자열
     */
    public String printResult(List<RacingCar> winners) {
        String res = "";
        res = winners.get(0).getName();
        for (int i=1;i<winners.size();i++) {
            res += ", " + winners.get(i).getName();
        }
        res += "가 최종 우승했습니다.";
        System.out.println(res);
        return res;
    }

    /**
     * 사용자에게 입력받은 자동차 이름 문자열을 RacingCar 리스트로 반환
     * 5자를 초과하는 이름이 존재할 경우 null을 리턴한다.
     * @param str 입력받은 자동차 이름 문자열 (구분자 ",")
     * @return RacingCar 리스트, 5자 초과하는 이름 있을 경우 null
     */
    public List<RacingCar> splitString(String str){
        String[] name_array = str.split(",");
        int len = name_array.length;
        List<RacingCar> res = new ArrayList<>();


        if(!checkLengthOfNames(name_array)){
            return null;
        }

        for(int i=0;i<len;i++){
            res.add(new RacingCar(name_array[i]));
        }
        return res;
    }

    /**
     * 각 이름이 5자 이하인지를 확인
     * @param names 이름 배열
     * @return 모두 5자 이하일 경우 true
     */
    public boolean checkLengthOfNames(String[] names) {
        boolean flag = true;
        for(String name : names){
            flag = flag&& (name.length()<=5);
        }
        return flag;
    }
}
