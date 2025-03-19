package hu.nye.energydrink.controller;

import hu.nye.energydrink.entity.EnergyDrink;
import hu.nye.energydrink.service.EnergyDrinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class EnergyDrinkController {

    private final EnergyDrinkService service;

    public EnergyDrinkController(EnergyDrinkService service) {
        this.service = service;
    }

    @GetMapping
    public List<EnergyDrink> getAllDrinks() {
        return service.findAll();
    }

    @GetMapping("/filter")
    public List<EnergyDrink> getDrinksByCaffeine(@RequestParam double minCaffeine, @RequestParam double maxCaffeine) {
        return service.findByCaffeineRange(minCaffeine, maxCaffeine);
    }

    @PostMapping
    public EnergyDrink addDrink(@RequestBody EnergyDrink drink) {
        drink.calculateCaffeinePer100ml();
        drink.calculateCaloriesPer100ml();
        return service.save(drink);
    }
}
