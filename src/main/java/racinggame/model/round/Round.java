package racinggame.model.round;


public class Round {
	int endTurn;

	public Round(int num){
		this.endTurn = num;
	}

	public int getRound(){
		return this.endTurn;
	}
}
