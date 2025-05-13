package service.impl;

import entity.Brand;
import repository.IBrandRepository;
import repository.impl.BrandRepository;
import service.IBrandService;
import service.ICarService;

import java.util.List;

public class BrandService implements IBrandService {
    private IBrandRepository repository = new BrandRepository();

    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }

    @Override
    public Brand findById(String id) {
        return repository.findById(id);
    }
}
