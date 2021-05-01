public class Game {
    private static int goal;

    public Game(int goal) {
        if (goal < 1) {
            throw new IllegalArgumentException("1 이상의 수를 입력해주세요.");
        }
        Game.goal = goal;
    }

    public static int getGoal() {
        return goal;
    }
}
