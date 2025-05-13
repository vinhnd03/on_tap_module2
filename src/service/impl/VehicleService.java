package service.impl;

import entity.Car;
import entity.Drone;
import entity.Vehicle;
import repository.ICarRepository;
import repository.IDroneRepository;
import repository.IVehicleRepository;
import repository.impl.CarRepository;
import repository.impl.DroneRepository;
import repository.impl.VehicleRepository;
import service.IVehicleService;
import view.View;

import java.util.List;

public class VehicleService implements IVehicleService {
    private IVehicleRepository repository = new VehicleRepository();

    @Override
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    public Vehicle findById(String id) {
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
