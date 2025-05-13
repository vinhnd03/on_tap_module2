package repository;

import entity.Brand;

import java.util.List;

public interface IBrandRepository {
    List<Brand> findAll();

    Brand findById(String id);
}
