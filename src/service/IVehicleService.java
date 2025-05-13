package service;

import entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> findAll();

    Vehicle findById(String id);

    Vehicle findByCoordinator(String coordinator);

    void deleteById(String id);
}
