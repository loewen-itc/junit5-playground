package de.loewenitc.extension;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomNameGenerator {

    public String randomName(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}
