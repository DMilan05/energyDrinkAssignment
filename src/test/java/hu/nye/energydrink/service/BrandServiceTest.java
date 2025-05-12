package hu.nye.energydrink.service;

import hu.nye.energydrink.entity.Brand;
import hu.nye.energydrink.exception.NoSuchEntityException;
import hu.nye.energydrink.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BrandServiceTest {

    @Mock
    private BrandRepository brandRepositoryMock;

    @InjectMocks
    private BrandService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBrandsHappyPath() {
        // GIVEN
        List<Brand> expected = List.of(
                Brand.builder().id(1L).name("Hell").country("Hungary").build(),
                Brand.builder().id(2L).name("Monster").country("USA").build()
        );
        when(brandRepositoryMock.findAll()).thenReturn(expected);

        // WHEN
        List<Brand> result = underTest.getAllBrands();

        // THEN
        assertEquals(expected, result);
    }

    @Test
    void saveHappyPath() {
        // GIVEN
        Brand brand = Brand.builder().id(1L).name("Hell").country("Hungary").build();
        when(brandRepositoryMock.save(brand)).thenReturn(brand);

        // WHEN
        Brand result = underTest.save(brand);

        // THEN
        assertEquals(brand, result);
    }

    @Test
    void editHappyPath() {
        // GIVEN
        Brand brand = Brand.builder().id(1L).name("Hell").country("Hungary").build();
        when(brandRepositoryMock.save(brand)).thenReturn(brand);

        // WHEN
        Brand result = underTest.edit(brand);

        // THEN
        assertEquals(brand, result);
    }

    @Test
    void findByIdWhenExists() {
        // GIVEN
        Brand brand = Brand.builder().id(1L).name("Hell").country("Hungary").build();
        when(brandRepositoryMock.findById(1L)).thenReturn(Optional.of(brand));

        // WHEN
        Brand result = underTest.findById(1L);

        // THEN
        assertEquals(brand, result);
    }

    @Test
    void findByIdWhenMissing() {
        // GIVEN
        when(brandRepositoryMock.findById(99L)).thenReturn(Optional.empty());

        // WHEN + THEN
        NoSuchEntityException exception = assertThrows(NoSuchEntityException.class,
                () -> underTest.findById(99L));
        assertEquals("There was no brand with id: 99", exception.getMessage());
    }

    @Test
    void deleteByIdHappyPath() {
        // GIVEN
        Long id = 1L;

        // WHEN
        underTest.deleteById(id);

        // THEN
        verify(brandRepositoryMock).deleteById(id);
    }
}
