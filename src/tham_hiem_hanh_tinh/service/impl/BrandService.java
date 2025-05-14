package tham_hiem_hanh_tinh.service.impl;

import tham_hiem_hanh_tinh.entity.Brand;
import tham_hiem_hanh_tinh.repository.IBrandRepository;
import tham_hiem_hanh_tinh.repository.impl.BrandRepository;
import tham_hiem_hanh_tinh.service.IBrandService;

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
