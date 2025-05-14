package tham_hiem_hanh_tinh.service.impl;

import tham_hiem_hanh_tinh.entity.Drone;
import tham_hiem_hanh_tinh.repository.IDroneRepository;
import tham_hiem_hanh_tinh.repository.impl.DroneRepository;
import tham_hiem_hanh_tinh.service.IDroneService;

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
