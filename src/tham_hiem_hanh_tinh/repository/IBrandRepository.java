package tham_hiem_hanh_tinh.repository;

import tham_hiem_hanh_tinh.entity.Brand;

import java.util.List;

public interface IBrandRepository {
    List<Brand> findAll();

    Brand findById(String id);
}
