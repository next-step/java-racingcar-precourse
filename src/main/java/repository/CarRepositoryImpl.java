package repository;

import java.util.ArrayList;
import model.RacingCarDTO;

public class CarRepositoryImpl implements CarRepository {
    private final ArrayList<RacingCarDTO> carArrList = new ArrayList<>();

    // CRUD
    @Override
    public void add(String name) {
        carArrList.add(new RacingCarDTO(name));
    }

    @Override
    public RacingCarDTO get(String name) {
        for (RacingCarDTO car : carArrList) {
            if (car.getName().equals(name)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public ArrayList<RacingCarDTO> getAllCars() {
        return carArrList;
    }

    @Override
    public void update(RacingCarDTO car) {
        for (int i = 0; i < carArrList.size(); i++) {
            if (carArrList.get(i).getName().equals(car.getName())) {
                carArrList.set(i, car);
                return;
            }
        }
    }

    @Override
    public void delete(String name) {
        carArrList.removeIf(car -> car.getName().equals(name));
    }

    @Override
    public void clear() {
        carArrList.clear();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(RacingCarDTO car : carArrList){
            sb.append(car.toString());
        }
        return sb.toString();
    }
}
