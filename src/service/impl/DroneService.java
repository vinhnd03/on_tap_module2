package service.impl;

import entity.Drone;
import repository.IDroneRepository;
import repository.impl.DroneRepository;
import service.IDroneService;

import java.util.List;

public class DroneService implements IDroneService {
    private IDroneRepository repository = new DroneRepository();

    @Override
    public void add(Drone drone) {
        repository.add(drone);
    }

    @Override
    public List<Drone> findAll() {
        return repository.findAll();
    }
}
