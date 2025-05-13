package repository;

import entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle findById(String id);

    Vehicle findByCoordinator(String coordinator);

    void deleteById(String id);
}
