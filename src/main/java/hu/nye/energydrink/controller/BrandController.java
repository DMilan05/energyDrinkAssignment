package hu.nye.energydrink.controller;

import hu.nye.energydrink.entity.Brand;
import hu.nye.energydrink.service.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public List<Brand> getAllBrands() {
        return service.findAll();
    }

    @PostMapping
    public Brand addBrand(@RequestBody Brand brand) {
        return service.save(brand);
    }
}
