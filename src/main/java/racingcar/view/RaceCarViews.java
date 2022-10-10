package racingcar.view;

import java.util.Iterator;
import java.util.List;

public class RaceCarViews implements Iterable<RaceCarView> {
    private final List<RaceCarView> views;

    private RaceCarViews(List<RaceCarView> views) {
        this.views = views;
    }

    public static RaceCarViews of(List<RaceCarView> views) {
        return new RaceCarViews(views);
    }

    @Override
    public Iterator<RaceCarView> iterator() {
        return views.iterator();
    }
}
