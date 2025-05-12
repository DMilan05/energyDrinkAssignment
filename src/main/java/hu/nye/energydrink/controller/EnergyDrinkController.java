package hu.nye.energydrink.controller;
import hu.nye.energydrink.entity.EnergyDrink;
import hu.nye.energydrink.service.BrandService;
import hu.nye.energydrink.service.EnergyDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller
@RequestMapping("/drinks")
public class EnergyDrinkController {

    @Autowired
    private EnergyDrinkService energyDrinkService;
    @Autowired
    private BrandService brandService;
    // GET: List all energyDrinks (responds to /drinks/list)
    @GetMapping("/list")
    public String getAllEnergyDrinks(Model model) {
        List<EnergyDrink> energyDrinks = energyDrinkService.
                getAllEnergyDrinks();
        model.
                addAttribute("energyDrinks", energyDrinks);
        return "energyDrinks/energyDrinks";
    }

    // GET: Show Create EnergyDrink Page
    @GetMapping("/new")
    public String createEnergyDrinksForm(Model model) {
        model.
                addAttribute("energyDrink", new EnergyDrink());
        model.
                addAttribute("brands", brandService.getAllBrands());
        return "energyDrinks/create-energyDrink";
    }

    // POST: Save New EnergyDrinks
    @PostMapping
    public String saveEnergyDrink(@ModelAttribute EnergyDrink energyDrink) {
        energyDrinkService.save(energyDrink);
        return "redirect:/drinks/list"; // Corrected redirect path
    }

    // GET: Show Edit EnergyDrink Page
    @GetMapping("/edit/{id}")
    public String editEnergyDrinkForm(@PathVariable Long id, Model model) {
        EnergyDrink energyDrink = energyDrinkService.findById(id);
        model.addAttribute("energyDrink", energyDrink);
        model.addAttribute("brands", brandService.getAllBrands());
        return "energyDrinks/edit-energyDrink";
    }


    // POST: Update Existing EnergyDrink
    @PostMapping("/edit")
    public String updateEnergyDrinks(@ModelAttribute EnergyDrink energyDrink) {
        energyDrinkService.edit(energyDrink);
        return "redirect:/drinks/list"; // Corrected redirect path
    }


    // POST: Delete EnergyDrink
    @PostMapping("/delete/{id}")
    public String deleteEnergyDrinks(@PathVariable Long id) {
        energyDrinkService.deleteById(id);
        return "redirect:/drinks/list"; // Corrected redirect path
    }

    @GetMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Long id, Model model) {
        EnergyDrink energyDrink = energyDrinkService.findById(id);
        model.addAttribute("energyDrink", energyDrink);
        return "energyDrinks/delete-energyDrink";
    }

}
