package service;

import entity.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> findAll();

    Brand findById(String id);
}
