package tham_hiem_hanh_tinh.repository.impl;

import tham_hiem_hanh_tinh.entity.Car;
import tham_hiem_hanh_tinh.entity.Drone;
import tham_hiem_hanh_tinh.entity.Vehicle;
import tham_hiem_hanh_tinh.repository.ICarRepository;
import tham_hiem_hanh_tinh.repository.IDroneRepository;
import tham_hiem_hanh_tinh.repository.IVehicleRepository;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository implements IVehicleRepository {
    private IDroneRepository droneRepository = new DroneRepository();
    private ICarRepository carRepository = new CarRepository();

    @Override
    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(droneRepository.findAll());
        vehicles.addAll(carRepository.findAll());
        return vehicles;
    }

    @Override
    public Vehicle findById(String id) {
        for (Vehicle vehicle : findAll()) {
            if (vehicle.getId().equals(id)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public Vehicle findByCoordinator(String coordinator) {
        for (Vehicle vehicle : findAll()) {
            if (vehicle.getCoordinator().equals(coordinator)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        for (Vehicle vehicle : findAll()){
            if(vehicle.getId().equals(id)){
                if(vehicle instanceof Car){
                    carRepository.deleteById(id);
                }else if(vehicle instanceof Drone){
                    droneRepository.deleteById(id);
                }
            }
        }
    }
}
