package hu.nye.energydrink.repository;

import hu.nye.energydrink.entity.EnergyDrink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnergyDrinkRepository extends JpaRepository<EnergyDrink, UUID> {
    List<EnergyDrink> findByCaffeinePer100mlBetween(double min, double max);
}
