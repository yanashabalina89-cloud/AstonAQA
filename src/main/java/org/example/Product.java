package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private float price;
    private boolean isReserved;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, float price, boolean isReserved) {
        this.name = name;
        this.productionDate = LocalDate.parse(productionDate, DEFAULT_DATE_FORMATTER);
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void printInformation(){
        System.out.println("Name: " + this.name +
                "\nProduction Date: " + this.productionDate.format(DEFAULT_DATE_FORMATTER) +
                "\nManufacturer: " + this.manufacturer +
                "\nCountry Of Origin: " + this.countryOfOrigin +
                "\nPrice: " + this.price +
                "\nReserved: " + this.isReserved
        );
    }
}
