package de.loewenitc.parameterizedtest.model;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Person {
    @Size(min = 1, max = 120)
    private String surname;
    @Size(min = 1, max = 120)
    private String lastname;
    @Valid
    private Address address;
    @Email
    private String email;
}
