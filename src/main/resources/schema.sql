CREATE TABLE Brand (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL
);

CREATE TABLE EnergyDrink (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    caffeineContent INT NOT NULL,
    sugarContent INT NOT NULL,
    volume INT NOT NULL,
    carbonated BOOLEAN NOT NULL,
    flavor VARCHAR(255),
    caffeinePer100ml INT NOT NULL,
    caloriesPer100ml INT NOT NULL,
    brand_id INT,
    CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES Brand(id)
);

