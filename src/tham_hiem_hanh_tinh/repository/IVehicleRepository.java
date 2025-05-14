package tham_hiem_hanh_tinh.repository;

import tham_hiem_hanh_tinh.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle findById(String id);

    Vehicle findByCoordinator(String coordinator);

    void deleteById(String id);
}
