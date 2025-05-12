package hu.nye.energydrink.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import hu.nye.energydrink.repository.BrandRepository;
import hu.nye.energydrink.service.EnergyDrinkService;
import hu.nye.energydrink.repository.EnergyDrinkRepository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import hu.nye.energydrink.exception.NoSuchEntityException;

@ExtendWith(MockitoExtension.class)
public class EnergyDrinkServiceTest {
    @Mock
    private EnergyDrinkRepository energyDrinkRepositoryMock;

    @InjectMocks
    private EnergyDrinkService underTest;


}
