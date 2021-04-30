import java.util.Scanner;

public class RaceGameMain {
	static Scanner inputSc = new Scanner(System.in); 
	
	public static void main(String[] args) {
		String intStr = inputString();
		int intNum = inputNumber();
		SplitString splitStr = new SplitString(intStr);
		RaceGame rg = new RaceGame(new Cars(splitStr.getSplitString()));
		rg.startNthGames(rg.getRaceCars(), intNum);
		System.out.println(rg.printGameResult(
			rg.getRaceCars(), rg.getMaxScore(rg.getRaceCars()))
			+ "가 최종 우승했습니다");
	}

	public static String inputString() {
		System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
		String inputStr = inputSc.next();
		if (inputStr.length() == 0) {
			return inputString();
		}
		return inputStr;
	}	
	
	public static int inputNumber() {
		System.out.println("시도할 횟수는 몇회인가요?");
		String inputStr = inputSc.next();
		int resNum = 0;
		try {
			resNum = Integer.parseInt(inputStr);
		} catch (NumberFormatException e) {
			return inputNumber();
		}
		return resNum <= 0 ? inputNumber() : resNum;
	}	
}
