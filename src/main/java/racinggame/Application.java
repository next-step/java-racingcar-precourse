package racinggame;

import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class Application {
	private RacingCars racingCars;
	private Rounds rounds;
	private RacingContest contest; 
	private boolean isNotFinished = true;
	
    public static void main(String[] args) {
    	Application app = new Application();
    	app.startApp();
    }
    
    private void startApp() {
    	while (this.isNotFinished) {
    		start();
    	}
    }
    
    private void start() {
    	try {
    		inputCars();
    		inputRounds();
    		makeContest();
    		this.contest.start();
    		this.contest.announceWinner();
	    	gameOver();
    	} catch (IllegalArgumentException e) {}
    }
    
    private void inputCars() {
    	if (this.racingCars == null) {
    		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    		this.racingCars = new RacingCars(inputCarNames());
    	}
    }
    
    private String inputCarNames() {
    	try {
    		return Console.readLine();
    	} catch (NoSuchElementException e) {
    		System.out.println(Car.NO_NAME);
    		throw e;
    	}
    }
    
    private void inputRounds() {
    	if (this.rounds == null) {
    		System.out.println("시도할 회수는 몇회인가요?");
    		this.rounds = new Rounds(Console.readLine());
    	}
    }
    
    private void makeContest() {
    	this.contest = new RacingContest(racingCars, rounds);
    }
    
    private void gameOver() {
    	this.isNotFinished = false;
    }    	
}
