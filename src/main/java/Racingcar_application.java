import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Racingcar_application {

    public static void main(String[] args) throws IOException {
        // 1. 자동차 이름 입력
        StringTokenizer st = getCarName();

        // 2. 시도할 횟수 입력
        int cnt = getTryCnt();

        Map<String, String> raceMap = new LinkedHashMap<>();
        while(st.hasMoreElements()){
            raceMap.put(st.nextToken(), "");
        }

        for(int i=0; i<cnt; i++) {
            // 4. 0-9 사이 무작위 값 생성
            // 5. 무작위 값이 4이상인 경우, 전진
            raceMap = startRacing(raceMap);
            // 3. 횟수별로 자동차 이름 출력
            printRacing(raceMap);
        }

        // 6. 우승자 식별
        String winner = getWinner(raceMap);
        // 7. 우승자 출력
        System.out.println("최종 우승자 : " + winner);
    }

    private static int getTryCnt() {
        int cnt = 0;
        try {
            System.out.println("시도할 횟수는 몇 회인가요?");
            Scanner sc = new Scanner(System.in);
            cnt = sc.nextInt();
        }catch(Exception ex){
            System.out.println("[ERROR] "+ ex.toString() + " : 입력이 잘못되었습니다.");
            getTryCnt();
        }

        return cnt;
    }

    private static StringTokenizer getCarName() throws IOException {
        BufferedReader bf = null;
        StringTokenizer st = null;
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(bf.readLine(), ",");
        }catch(IllegalArgumentException ex){
            System.out.println("[ERROR] "+ ex.toString() + " : 입력이 잘못되었습니다.");
            getCarName();
        }catch(Exception ex){
            System.out.println("[ERROR] "+ ex.toString() + " : 입력이 잘못되었습니다.");
            getCarName();
        }
        return st;
    }

    private static String getWinner(Map<String, String> raceMap) {
        int winRace = 0;
        int raceCnt = 0;
        String winner = "";

        for(String s : raceMap.keySet()){
            raceCnt = raceMap.get(s).length();
            if(winRace <= raceCnt) winRace = raceCnt;
        }

        for(String s : raceMap.keySet()){
            if (raceMap.get(s).length() == winRace){
                winner = winner + ", " + s;
            }
        }
        if (winner.startsWith(", ")){
            winner = winner.replaceFirst(", ", "");
        }
        return winner;
    }

    private static Map<String, String> startRacing(Map<String, String> raceMap) {
        Random random = new Random();
        int randNum = 0;
        for(String s : raceMap.keySet()){
            randNum = random.nextInt(9);
            if (randNum > 4) {
                raceMap.put(s, raceMap.get(s) + "-");
            }
        }
        return raceMap;
    }

    private static void printRacing(Map<String, String> raceMap) {
        for(String s : raceMap.keySet()){
            System.out.println(s + " : " + raceMap.get(s));
        }
        System.out.println("");
    }

}
