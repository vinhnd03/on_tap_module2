package repository;

import entity.Car;

import java.util.List;

public interface ICarRepository {
    void add(Car car);

    List<Car> findAll();

    void deleteById(String id);
}
