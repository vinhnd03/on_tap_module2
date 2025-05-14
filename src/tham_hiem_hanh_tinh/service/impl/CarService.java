package tham_hiem_hanh_tinh.service.impl;

import tham_hiem_hanh_tinh.entity.Car;
import tham_hiem_hanh_tinh.repository.ICarRepository;
import tham_hiem_hanh_tinh.repository.impl.CarRepository;
import tham_hiem_hanh_tinh.service.ICarService;

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
