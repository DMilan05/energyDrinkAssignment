package hu.nye.energydrink.entity;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EnergyDrink")
public class EnergyDrink {
    private static final int BASE_VOLUME = 100;
    private static final double CALORIES_PER_GRAM_SUGAR = 4.0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "caffeineContent")
    private int caffeineContent;  // Teljes koffeintartalom (mg)
    private int sugarContent;  // Cukortartalom (gramm)
    private int volume;  // Kiszerelés (ml)
    private boolean carbonated;  // Szénsavas-e
    private String flavor;
    private double caffeinePer100ml;  // mg/100ml
    private double caloriesPer100ml;  // kcal/100ml

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public void calculateCaffeinePer100ml() {
        if (volume > 0) {
            this.caffeinePer100ml = (double) caffeineContent
                    / volume * BASE_VOLUME;

        }
    }

    public void calculateCaloriesPer100ml() {
        if (sugarContent > 0) {
            this.caloriesPer100ml = sugarContent * CALORIES_PER_GRAM_SUGAR;
        }
    }
}
