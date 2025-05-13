package service.impl;

import entity.Car;
import repository.ICarRepository;
import repository.impl.CarRepository;
import service.ICarService;

import java.util.List;

public class CarService implements ICarService {
    private ICarRepository repository = new CarRepository();

    @Override
    public void add(Car car) {
        repository.add(car);
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }
}
