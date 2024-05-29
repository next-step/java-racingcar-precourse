package katecam.racingcar.adaptor.out;

import katecam.racingcar.application.port.out.GameRepository;
import katecam.racingcar.domain.Game;

public class InMemoryGameRepository implements GameRepository {
    private Game game;
    @Override
    public void save(Game game) {
        if (this.game != null)
            throw new IllegalStateException("저장된 게임 있음");
        this.game = game;
    }

    @Override
    public Game getOrThrow() {
        if (this.game == null)
            throw new IllegalStateException("저장된 게임 없음");
        return this.game;
    }

    @Override
    public void delete(){
        this.game = null;
    }
}
