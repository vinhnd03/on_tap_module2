package service;

import entity.Car;

import java.util.List;

public interface ICarService {
    void add(Car car);

    List<Car> findAll();
}
