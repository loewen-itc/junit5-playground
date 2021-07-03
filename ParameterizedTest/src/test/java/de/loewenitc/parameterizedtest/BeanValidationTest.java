package de.loewenitc.parameterizedtest;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import de.loewenitc.parameterizedtest.model.Address;
import de.loewenitc.parameterizedtest.model.Book;
import de.loewenitc.parameterizedtest.model.Library;
import de.loewenitc.parameterizedtest.model.Person;

public class BeanValidationTest {

    @ParameterizedTest
    @MethodSource("testData")
    void testBeanValidation(Library library, Integer errors) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Library>> result = validator.validate(library);
        Assertions.assertEquals(errors, result.size());
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(createFilledLibraryModel(), 0),
                Arguments.of(invalidCustomer(), 3),
                Arguments.of(invalidBook(), 3),
                Arguments.of(invalidAddress(), 4)
        );
    }

    private static Library invalidBook() {
        Library filledLibraryModel = createFilledLibraryModel();
        filledLibraryModel.getBooks().get(0).setTitle("");
        filledLibraryModel.getBooks().get(0).setGenre("");
        filledLibraryModel.getBooks().get(0).setAuthor("");
        return filledLibraryModel;
    }
    private static Library invalidCustomer() {
        Library filledLibraryModel = createFilledLibraryModel();
        filledLibraryModel.getCustomer().get(0).setSurname("");
        filledLibraryModel.getCustomer().get(0).setLastname("Asdfgasdffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdfffsdfgasdffff");
        filledLibraryModel.getCustomer().get(0).setEmail("john.doe");
        return filledLibraryModel;
    }

    private static Library invalidAddress() {
        Library filledLibraryModel = createFilledLibraryModel();
        filledLibraryModel.getEmployees().get(0).getAddress().setStreet("");
        filledLibraryModel.getEmployees().get(0).getAddress().setNumber("1234567");
        filledLibraryModel.getEmployees().get(0).getAddress().setPostalCode("105572");
        filledLibraryModel.getEmployees().get(0).getAddress().setCity("A");
        return filledLibraryModel;
    }

    private static Library createFilledLibraryModel() {
        Library library = new Library();
        library.setBooks(Arrays.asList(createFilledBook()));
        library.setCustomer(Arrays.asList(createFilledCustomer()));
        library.setEmployees(Arrays.asList(createFilledEmployee()));
        return library;
    }

    private static Person createFilledEmployee() {
        Person person = new Person();
        person.setLastname("Doe");
        person.setSurname("John");
        person.setAddress(createFilledAddress());
        person.setEmail("john.doe@example.org");
        return person;
    }

    private static Person createFilledCustomer() {
        Person person = new Person();
        person.setLastname("Doe");
        person.setSurname("Jill");
        person.setAddress(createFilledAddress());
        person.setEmail("jill.doe@example.org");
        return person;
    }

    private static Address createFilledAddress() {
        Address address = new Address();
        address.setStreet("John-Foster-Dulles-Allee");
        address.setNumber("10");
        address.setPostalCode("10557");
        address.setCity("Berlin");
        return address;
    }

    private static Book createFilledBook() {
        Book book = new Book();
        book.setTitle("Die Blechtrommel");
        book.setAuthor("Günter Grass");
        book.setPages(300);
        book.setGenre("Political Fiction");
        return book;
    }

}
