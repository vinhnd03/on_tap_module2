package tham_hiem_hanh_tinh.service;

import tham_hiem_hanh_tinh.entity.Car;

import java.util.List;

public interface ICarService {
    void add(Car car);

    List<Car> findAll();
}
