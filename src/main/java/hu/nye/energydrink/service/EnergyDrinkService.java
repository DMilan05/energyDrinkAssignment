package hu.nye.energydrink.service;

import hu.nye.energydrink.entity.EnergyDrink;
import hu.nye.energydrink.repository.EnergyDrinkRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnergyDrinkService {

    private final EnergyDrinkRepository repository;

    public EnergyDrinkService(EnergyDrinkRepository repository) {
        this.repository = repository;
    }

    public List<EnergyDrink> findAll() {
        return repository.findAll();
    }

    public List<EnergyDrink> findByCaffeineRange(double min, double max) {
        return repository.findByCaffeinePer100mlBetween(min, max);
    }

    public EnergyDrink save(EnergyDrink drink) {
        drink.calculateCaffeinePer100ml();
        drink.calculateCaloriesPer100ml();
        return repository.save(drink);
    }
}
