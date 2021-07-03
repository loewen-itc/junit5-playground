package de.loewenitc.parameterizedtest.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Book {
    @NotEmpty
    private String title;
    private Integer pages;
    @NotEmpty
    private String genre;
    @NotEmpty
    private String author;
}
