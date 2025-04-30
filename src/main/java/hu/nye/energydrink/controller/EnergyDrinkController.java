package hu.nye.energydrink.controller;

import hu.nye.energydrink.entity.EnergyDrink;
import hu.nye.energydrink.service.BrandService;
import hu.nye.energydrink.service.EnergyDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller

@RequestMapping("/drinks")
public class EnergyDrinkController {
    /*@Autowired
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
    }*/
    @Autowired
    private EnergyDrinkService energyDrinkService;
    @Autowired
    private BrandService brandServiceService;

    // GET: List all energyDrinks (responds to /energyDrinks/list)
    @GetMapping("/list")
    public String getAllEnergyDrinks(Model model) {
        List<EnergyDrink> energyDrinks = energyDrinkService.getAllEnergyDrinks();
        model.addAttribute("energyDrinks", energyDrinks);
        return "energyDrinks/energyDrinks"; // Updated template path (energyDrinks directory)
    }

    // GET: Show Create EnergyDrink Page
    @GetMapping("/new")
    public String createEnergyDrinksForm(Model model) {
        model.addAttribute("energyDrink", new EnergyDrink());
        model.addAttribute("brands", brandServiceService.getAllBrands()); // Brands list for dropdown
        return "energyDrinks/create-energyDrink"; // Updated template path
    }

    // POST: Save New EnergyDrinks
    @PostMapping
    public String saveEnergyDrink(@ModelAttribute EnergyDrink energyDrink) {
        energyDrinkService.save(energyDrink);
        return "redirect:/energyDrinks/list"; // Redirect to updated /energyDrinks/list after saving
    }

    // GET: Show Edit EnergyDrink Page
    @GetMapping("/edit/{id}")
    public String editEnergyDrinkForm(@PathVariable UUID id, Model model) {
        EnergyDrink energyDrink = energyDrinkService.findById(id);
        model.addAttribute("energyDrink", energyDrink);
        model.addAttribute("energyDrinks", energyDrinkService.getAllEnergyDrinks()); // EnergyDrinks list for dropdown
        return "energyDrinks/edit-energyDrink"; // Updated template path
    }

    // POST: Update Existing EnergyDrink
    @PostMapping("/edit")
    public String updateEnergyDrinksk(@ModelAttribute EnergyDrink energyDrink) {
        energyDrinkService.edit(energyDrink);
        return "redirect:/energyDrinks/list"; // Redirect to updated /energyDrinks/list after updating
    }

    // POST: Delete EnergyDrink
    @PostMapping("/delete/{id}")
    public String deleteEnergyDrinks(@PathVariable UUID id) {
        energyDrinkService.deleteById(id);
        return "redirect:/energyDrinks/list"; // Redirect to updated /energyDrinks/list after deleting
    }
}
