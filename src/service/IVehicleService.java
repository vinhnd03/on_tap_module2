package service;

import common.NotFoundVehicleException;
import entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> findAll();

    Vehicle findById(String id) throws NotFoundVehicleException;

    Vehicle findByCoordinator(String coordinator);

    void deleteById(String id);
}
