package hu.nye.energydrink.repository;

import hu.nye.energydrink.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
