package service;

import entity.Drone;

import java.util.List;

public interface IDroneService {
    void add(Drone drone);

    List<Drone> findAll();
}
