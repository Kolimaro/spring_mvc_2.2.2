package web.DAO;

import org.springframework.stereotype.Repository;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    @Override
    public List<Car> allCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mers", "black", "a777aa"));
        cars.add(new Car("Niva", "white", "e123ae"));
        cars.add(new Car("BelAZ", "yellow", "b400tt"));
        return cars;
    }
}
