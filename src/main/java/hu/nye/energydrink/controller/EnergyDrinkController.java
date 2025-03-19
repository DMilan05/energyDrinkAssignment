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

    @PostMapping
    public EnergyDrink addDrink(@RequestBody EnergyDrink drink) {
        return service.save(drink);
    }
}
