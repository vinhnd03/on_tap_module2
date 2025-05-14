package tham_hiem_hanh_tinh.service;

import tham_hiem_hanh_tinh.entity.Drone;

import java.util.List;

public interface IDroneService {
    void add(Drone drone);

    List<Drone> findAll();
}
