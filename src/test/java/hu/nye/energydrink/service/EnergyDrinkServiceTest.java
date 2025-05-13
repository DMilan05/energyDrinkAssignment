package hu.nye.energydrink.service;

import hu.nye.energydrink.entity.Brand;
import hu.nye.energydrink.entity.EnergyDrink;
import hu.nye.energydrink.repository.EnergyDrinkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EnergyDrinkServiceTest {

    @Mock
    private EnergyDrinkRepository energyDrinkRepositoryMock;

    @InjectMocks
    private EnergyDrinkService underTest;

    @Test
    void getAllEnergyDrinksHappyPath() {
        // GIVEN
        List<EnergyDrink> expectedDrinks = List.of(
                createSampleDrink(1L),
                createSampleDrink(2L)
        );
        when(energyDrinkRepositoryMock.findAll()).thenReturn(expectedDrinks);

        // WHEN
        List<EnergyDrink> result = underTest.getAllEnergyDrinks();

        // THEN
        assertEquals(expectedDrinks, result);
    }

    @Test
    void saveHappyPath() {
        // GIVEN
        EnergyDrink expected = createSampleDrink(1L);
        when(energyDrinkRepositoryMock.save(expected)).thenReturn(expected);

        // WHEN
        EnergyDrink result = underTest.save(expected);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void editHappyPath() {
        // GIVEN
        EnergyDrink expected = createSampleDrink(1L);
        when(energyDrinkRepositoryMock.save(expected)).thenReturn(expected);

        // WHEN
        EnergyDrink result = underTest.edit(expected);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void findByIdHappyPath() {
        // GIVEN
        Long id = 1L;
        EnergyDrink expected = createSampleDrink(id);
        when(energyDrinkRepositoryMock.findById(id)).thenReturn(Optional.of(expected));

        // WHEN
        EnergyDrink result = underTest.findById(id);

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void deleteByIdHappyPath() {
        // GIVEN
        Long id = 1L;

        // WHEN
        underTest.deleteById(id);

        // THEN

    }

    private EnergyDrink createSampleDrink(Long id) {
        return EnergyDrink.builder()
                .id(id)
                .name("Test Energy")
                .caffeineContent(160)
                .sugarContent(30)
                .volume(500)
                .carbonated(true)
                .flavor("Tropical")
                .caffeinePer100ml(32.0)
                .caloriesPer100ml(120.0)
                .brand(
                        Brand.builder()
                                .id(10L)
                                .name("TestBrand")
                                .country("Hungary")
                                .build()
                )
                .build();
    }
}
