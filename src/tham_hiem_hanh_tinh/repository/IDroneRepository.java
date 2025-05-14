package tham_hiem_hanh_tinh.repository;

import tham_hiem_hanh_tinh.entity.Drone;

import java.util.List;

public interface IDroneRepository {
    void add(Drone drone);

    List<Drone> findAll();

    void deleteById(String id);
}
