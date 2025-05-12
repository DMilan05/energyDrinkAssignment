package hu.nye.energydrink.repository;

import hu.nye.energydrink.entity.EnergyDrink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface EnergyDrinkRepository
        extends JpaRepository<EnergyDrink, Long> {
    List<EnergyDrink> findByCaffeinePer100mlBetween(double min, double max);
}
