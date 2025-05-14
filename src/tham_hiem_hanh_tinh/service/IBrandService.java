package tham_hiem_hanh_tinh.service;

import tham_hiem_hanh_tinh.entity.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> findAll();

    Brand findById(String id);
}
