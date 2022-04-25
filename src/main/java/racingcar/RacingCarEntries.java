package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class RacingCarEntries implements Iterable<RacingCar> {
    private ArrayList<RacingCar> entries;

    public RacingCarEntries() {
        entries = new ArrayList<>();
    }

    public RacingCarEntries(ArrayList<RacingCar> car_entries) {
        entries = car_entries;
    }

    public void addNewRacingCar(CarName car_name) {
        entries.add(new RacingCar(new CarName(car_name.toString())));
    }

    public RacingCar get(int index) {
        return entries.get(index);
    }

    public int size() {
        return  entries.size();
    }

    public void takeALap() {
        for (RacingCar car : entries) {
            car.moveOrStop();
        }
    }

    public void sortReverse() {
        entries.sort(Collections.reverseOrder());
    }

    public CommaSeparatedCarNames getWinnerNames() {
        CommaSeparatedCarNames csv_names = new CommaSeparatedCarNames();

        sortReverse();

        RacingCar top = entries.get(0);
        for (int i = 0; (i < entries.size()) && (top.compareTo(entries.get(i)) == 0); i++){
            csv_names.append(entries.get(i).getCarName());
        }

        return csv_names;
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return new RacingCarIterator();
    }

    class RacingCarIterator implements Iterator<RacingCar> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < entries.size();
        }

        @Override
        public RacingCar next() {
            RacingCar current = entries.get(index);
            index++;

            return current;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
