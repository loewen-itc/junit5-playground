package de.loewenitc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import de.loewenitc.extension.RandomLengthExtension;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class MugServiceTest {

    private MugService sut;

    @BeforeEach
    public void setUp() {
        RandomNameGenerator randomNameGenerator = new RandomNameGenerator();
        sut = new MugService(randomNameGenerator);
    }

    /**
     * Test a custom Extension Which generates a random length for the generated name
     */
    @ExtendWith(RandomLengthExtension.class)
    @Test
    public void testCustomRandomParametersExtension(@RandomLengthExtension.RandomLength int length) {
        Mug someColor = sut.createMug(MugType.ESPRESSO, "someColor", length);
        log.info(someColor.toString());
        Assertions.assertEquals(someColor.getRandomName().length(), length);
    }

}
