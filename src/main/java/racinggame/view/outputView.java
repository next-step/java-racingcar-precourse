package racinggame.view;

import nextstep.utils.Randoms;
import racinggame.Car;
import racinggame.Racing_game;
import racinggame.manage.*;

public class OutputView {
	private static final int MAX_NUM=9;
	private static final int MIN_NUM=1;
	
	public static void print_winner(Racing_game game) {
		for(int i=0;i<game.getTrycnt();i++) {
			play_game(game);			
		}
		
		System.out.printf("최종 우승자는 %s 입니다", String.join(",", game.get_all_winner()));
	}
	
	
	public static void play_game(Racing_game game) {
		for(int i=0;i<game.getCars().size();i++) {
			game.moving_Car(i, Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
			print_car(game.getCars().get(i));
		}
	}
	
	public static void print_car(Car car) {
		System.out.print(car.getCar_num()+":");
		for(int i=0;i<car.get_distance();i++) {
			System.out.print("-");
		}
		
		System.out.println();
	}
	

}
