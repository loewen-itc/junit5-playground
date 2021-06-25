package de.loewenitc;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MugService {

    private final RandomNameGenerator randomNameGenerator;

    public Mug createMug(MugType mugType, String color, int length) {
        return new Mug(mugType, color, randomNameGenerator.randomName(length));
    }
}
