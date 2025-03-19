package hu.nye.energydrink.service;

import hu.nye.energydrink.entity.Brand;
import hu.nye.energydrink.repository.BrandRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {

    private final BrandRepository repository;

    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public List<Brand> findAll() {
        return repository.findAll();
    }

    public Brand save(Brand brand) {
        return repository.save(brand);
    }
}
