package hu.nye.energydrink.controller;

import hu.nye.energydrink.entity.Brand;
import hu.nye.energydrink.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private final BrandService brandService;

    public BrandController(BrandService service) {
        this.brandService = service;
    }

    // GET: List all brands (responds to /brands/list)
    @GetMapping("/list")
    public String getAllBrands(Model model) {
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        return "brands/brands"; //
    }

    // GET: Show Create Brand Page
    @GetMapping("/new")
    public String createBrandForm(Model model) {
        model.addAttribute("brand", new Brand());
        return "brands/create-brand";
    }

    // POST: Save New Brand
    @PostMapping
    public String saveBrand(@ModelAttribute Brand brand) {
        brandService.save(brand);
        return "redirect:/brands/list"; // Redirect to /brands/list after saving
    }

    // GET: Show Edit Brand Page
    @GetMapping("/edit/{id}")
    public String editBrandForm(@PathVariable UUID id, Model model) {
        Brand brand = brandService.findById(id);
        model.addAttribute("brand", brand);
        return "brands/edit-brand";
    }

    // POST: Update Existing Brand
    @PostMapping("/edit")
    public String updateBrand(@ModelAttribute Brand brand) {
        brandService.edit(brand);
        return "redirect:/brands/list";
    }

    // POST: Delete Brand
    @PostMapping("/delete/{id}")
    public String deleteBrand(@PathVariable UUID id) {
        brandService.deleteById(id);
        return "redirect:/brands/list";
    }
}
