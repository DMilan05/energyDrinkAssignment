package hu.nye.energydrink.service;
import hu.nye.energydrink.entity.Brand;
import hu.nye.energydrink.exception.NoSuchEntityException;
import hu.nye.energydrink.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand edit(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand findById(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isPresent()) {
            return optionalBrand.get();
        } else {
            throw new NoSuchEntityException("There was no brand with id: "
                    + id);
        }
    }

    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }
}
