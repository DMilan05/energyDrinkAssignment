package hu.nye.energydrink.entity;

import jakarta.persistence.*;

@Entity
public class EnergyDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int caffeineContent;  // Teljes koffeintartalom (mg)
    private int sugarContent;  // Cukortartalom (gramm)
    private int volume;  // Kiszerelés (ml)
    private boolean carbonated;  // Szénsavas-e
    private String flavor;
    private double caffeinePer100ml;  // mg/100ml
    private double caloriesPer100ml;  // kcal/100ml

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

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

    public int getCaffeineContent() {
        return caffeineContent;
    }

    public void setCaffeineContent(int caffeineContent) {
        this.caffeineContent = caffeineContent;
    }

    public int getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(int sugarContent) {
        this.sugarContent = sugarContent;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isCarbonated() {
        return carbonated;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getCaffeinePer100ml() {
        return caffeinePer100ml;
    }

    public void setCaffeinePer100ml(double caffeinePer100ml) {
        this.caffeinePer100ml = caffeinePer100ml;
    }

    public double getCaloriesPer100ml() {
        return caloriesPer100ml;
    }

    public void setCaloriesPer100ml(double caloriesPer100ml) {
        this.caloriesPer100ml = caloriesPer100ml;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public EnergyDrink(Long id, String name, int caffeineContent, int sugarContent, int volume, boolean carbonated, String flavor, double caffeinePer100ml, double caloriesPer100ml, Brand brand) {
        this.id = id;
        this.name = name;
        this.caffeineContent = caffeineContent;
        this.sugarContent = sugarContent;
        this.volume = volume;
        this.carbonated = carbonated;
        this.flavor = flavor;
        this.caffeinePer100ml = caffeinePer100ml;
        this.caloriesPer100ml = caloriesPer100ml;
        this.brand = brand;
    }

    public void calculateCaffeinePer100ml() {
        if (volume > 0) {
            this.caffeinePer100ml = (double) caffeineContent / volume * 100;
        }
    }

    public void calculateCaloriesPer100ml() {
        if (sugarContent > 0) {
            this.caloriesPer100ml = sugarContent * 4.0; // 1g cukor ~4 kcal
        }
    }
}
