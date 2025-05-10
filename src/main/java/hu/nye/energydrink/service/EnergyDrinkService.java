package hu.nye.energydrink.service;

import hu.nye.energydrink.entity.EnergyDrink;
import hu.nye.energydrink.exception.NoSuchEntityException;
import hu.nye.energydrink.repository.EnergyDrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyDrinkService {

    private final EnergyDrinkRepository energyDrinkRepository;

    /*public EnergyDrinkService(EnergyDrinkRepository repository) {
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
    }*/
    public EnergyDrinkService(EnergyDrinkRepository energyDrinkRepository) {
        this.energyDrinkRepository = energyDrinkRepository;
    }

    public List<EnergyDrink> getAllEnergyDrinks() {
        return energyDrinkRepository.findAll();
    }

    public EnergyDrink save(EnergyDrink energyDrink) {
        return energyDrinkRepository.save(energyDrink);
    }

    public EnergyDrink edit(EnergyDrink energyDrink) {
        return energyDrinkRepository.save(energyDrink);
    }

    public EnergyDrink findById(Long id) {
        Optional<EnergyDrink> optionalEnergyDrink = energyDrinkRepository.findById(id);
        if (optionalEnergyDrink.isPresent()) {
            return optionalEnergyDrink.get();
        } else {
            throw new NoSuchEntityException("There was no brand with id: " + id);
        }
    }

    public void deleteById(Long id) {
        energyDrinkRepository.deleteById(id);
    }
}
