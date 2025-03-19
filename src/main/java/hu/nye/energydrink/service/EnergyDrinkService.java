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

    public EnergyDrink save(EnergyDrink drink) {
        return repository.save(drink);
    }
}
