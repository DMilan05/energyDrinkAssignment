package hu.nye.energydrink.repository;

import hu.nye.energydrink.entity.EnergyDrink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyDrinkRepository extends JpaRepository<EnergyDrink, Long> {
}
