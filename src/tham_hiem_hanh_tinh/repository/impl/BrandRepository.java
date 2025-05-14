package tham_hiem_hanh_tinh.repository.impl;

import tham_hiem_hanh_tinh.common.ReadAndWriteFile;
import tham_hiem_hanh_tinh.entity.Brand;
import tham_hiem_hanh_tinh.repository.IBrandRepository;

import java.util.ArrayList;
import java.util.List;

public class BrandRepository implements IBrandRepository {
    private static final String PATH = "src/tham_hiem_hanh_tinh/data/brand.csv";
    @Override
    public List<Brand> findAll() {
        List<String> stringList = ReadAndWriteFile.readFileCSV(PATH);
        List<Brand> brands = new ArrayList<>();
        for (String s : stringList){
            String[] array = s.split("\\s*,\\s*");
            brands.add(new Brand(array[0], array[1], array[2]));
        }
        return brands;
    }

    public Brand findById(String id){
        for (Brand brand : findAll()){
            if(brand.getId().equals(id)){
                return brand;
            }
        }
        return null;
    }
}
