package hu.nye.energydrink.entity;

import jakarta.persistence.*;

@Entity
public class EnergyDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private int caffeineContent;

    // Konstruktorok, getterek, setterek
}
