package tham_hiem_hanh_tinh.repository;

import tham_hiem_hanh_tinh.entity.Car;

import java.util.List;

public interface ICarRepository {
    void add(Car car);

    List<Car> findAll();

    void deleteById(String id);
}
