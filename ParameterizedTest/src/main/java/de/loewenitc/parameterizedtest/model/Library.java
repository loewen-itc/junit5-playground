package de.loewenitc.parameterizedtest.model;

import java.util.List;

import javax.validation.Valid;

import lombok.Data;

@Data
public class Library {
    @Valid
    private List<Book> books;
    @Valid
    private List<Person> employees;
    @Valid
    private List<Person> customer;
}
