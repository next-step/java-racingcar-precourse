package racingcar.models;

public class GameResultRepository {
    private final GameResult[] results;

    public GameResultRepository(GameResult[] results) {
        this.results = results;
    }

    public RacingScore getScores() {
        RacingScore scores = new RacingScore();
        for (GameResult result : this.results) {
            scores.merge(result.getDashboard());
        }
        return scores;
    }

    public String scoreToString(RacingScore scores) {
        String[] strings = new String[scores.size()];
        int i = 0;
        for (Car car : scores.getCars()) {
            int score = scores.getScoreOf(car);
            strings[i] = String.format("%s : %s", car.getName(), new String(new char[score]).replace("\0", "-"));
            i++;
        }
        return String.join("\n", strings);
    }

    @Override
    public String toString() {
        RacingScore baseScore = new RacingScore();
        String[] result = new String[this.results.length];
        for (int i = 0; i < this.results.length; i++) {
            GameResult gameResult = this.results[i];
            baseScore.merge(gameResult.getDashboard());
            result[i] = this.scoreToString(baseScore);
        }
        return String.join("\n", result);
    }
}
