package hu.nye.energydrink.service;
import hu.nye.energydrink.entity.EnergyDrink;
import hu.nye.energydrink.exception.NoSuchEntityException;
import hu.nye.energydrink.repository.EnergyDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergyDrinkService {
    @Autowired
    private EnergyDrinkRepository energyDrinkRepository;

    /*public EnergyDrinkService(EnergyDrinkRepository energyDrinkRepository) {
        this.energyDrinkRepository = energyDrinkRepository;
    }*/

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
        Optional<EnergyDrink> optionalEnergyDrink = energyDrinkRepository.
                findById(id);
        if (optionalEnergyDrink.isPresent()) {
            return optionalEnergyDrink.get();
        } else {
            throw new NoSuchEntityException(
                    "There was no brand with id: " + id
            );
        }
    }

    public void deleteById(Long id) {
        energyDrinkRepository.deleteById(id);
    }
}
