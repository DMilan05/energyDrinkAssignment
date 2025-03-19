INSERT INTO Brand (id, name, country) VALUES (1, 'Red Bull', 'Austria');
INSERT INTO Brand (id, name, country) VALUES (2, 'Monster', 'USA');
INSERT INTO Brand (id, name, country) VALUES (3, 'Hell', 'Hungary');

INSERT INTO EnergyDrink (name, caffeineContent, sugarContent, volume, carbonated, flavor, caffeinePer100ml, caloriesPer100ml, brand_id)
VALUES ('Red Bull Classic', 80, 27, 250, true, 'Classic', 32, 108, 1);

INSERT INTO EnergyDrink (name, caffeineContent, sugarContent, volume, carbonated, flavor, caffeinePer100ml, caloriesPer100ml, brand_id)
VALUES ('Monster Energy', 160, 54, 500, true, 'Original', 32, 108, 2);
