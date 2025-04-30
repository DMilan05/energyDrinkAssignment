package hu.nye.energydrink.service;

import hu.nye.energydrink.entity.Brand;
import hu.nye.energydrink.exception.NoSuchEntityException;
import hu.nye.energydrink.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrandService {

    private final BrandRepository brandRepository;


    /*public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public List<Brand> findAll() {
        return repository.findAll();
    }

    public Brand save(Brand brand) {
        return repository.save(brand);
    }*/
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand edit(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand findById(UUID id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isPresent()) {
            return optionalBrand.get();
        } else {
            throw new NoSuchEntityException("There was no brand with id: " + id);
        }
    }

    public void deleteById(UUID id) {
        brandRepository.deleteById(id);
    }
}
