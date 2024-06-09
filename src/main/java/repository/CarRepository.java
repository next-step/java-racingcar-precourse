package repository;

import java.util.ArrayList;
import model.RacingCarDTO;

public interface CarRepository {
    void add(String name);
    RacingCarDTO get(String name);
    ArrayList<RacingCarDTO> getAllCars();
    void update(RacingCarDTO car);
    void delete(String name);
    void clear();
}
