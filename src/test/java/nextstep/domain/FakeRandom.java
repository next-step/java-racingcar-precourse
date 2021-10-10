package nextstep.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FakeRandom implements Random{

    private final Iterator<Integer> it = new Iterator<Integer>() {

        private final List<Integer> list = Arrays.asList(4, 3, 4);
        private int size = 0;

        @Override
        public boolean hasNext() {
            return list.size() > size;
        }

        @Override
        public Integer next() {
            return list.get(size++);
        }
    };

    @Override
    public int generate() {
        if (it.hasNext()) {
            return it.next();
        }
        return 0;
    }
}
