package tham_hiem_hanh_tinh.service.impl;

import tham_hiem_hanh_tinh.common.NotFoundVehicleException;
import tham_hiem_hanh_tinh.entity.Vehicle;
import tham_hiem_hanh_tinh.repository.IVehicleRepository;
import tham_hiem_hanh_tinh.repository.impl.VehicleRepository;
import tham_hiem_hanh_tinh.service.IVehicleService;

import java.util.List;

public class VehicleService implements IVehicleService {
    private IVehicleRepository repository = new VehicleRepository();

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle findById(String id){
        return repository.findById(id);
    }

    @Override
    public Vehicle findByCoordinator(String coordinator) {
        return repository.findByCoordinator(coordinator);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
