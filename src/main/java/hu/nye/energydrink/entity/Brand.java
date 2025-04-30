package hu.nye.energydrink.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    //@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnergyDrink> drinks;

    public Brand(Long id, String name, String country, List<EnergyDrink> drinks) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.drinks = drinks;
    }

    public Brand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<EnergyDrink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<EnergyDrink> drinks) {
        this.drinks = drinks;
    }
}
