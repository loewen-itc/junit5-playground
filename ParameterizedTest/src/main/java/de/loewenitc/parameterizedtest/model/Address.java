package de.loewenitc.parameterizedtest.model;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Address {
    @Size(min = 1, max = 120)
    private String street;
    @Size(min = 1, max = 6)
    private String number;
    @Size(min = 5, max = 5)
    private String postalCode;
    @Size(min = 2, max = 120)
    private String city;
}
