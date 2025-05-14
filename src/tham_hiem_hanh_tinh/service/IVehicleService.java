package tham_hiem_hanh_tinh.service;

import tham_hiem_hanh_tinh.common.NotFoundVehicleException;
import tham_hiem_hanh_tinh.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<Vehicle> findAll();

    Vehicle findById(String id);

    Vehicle findByCoordinator(String coordinator);

    void deleteById(String id);
}
