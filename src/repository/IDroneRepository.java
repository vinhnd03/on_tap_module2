package repository;

import entity.Drone;
import entity.Vehicle;

import java.util.Collection;
import java.util.List;

public interface IDroneRepository {
    void add(Drone drone);

    List<Drone> findAll();

    void deleteById(String id);
}
