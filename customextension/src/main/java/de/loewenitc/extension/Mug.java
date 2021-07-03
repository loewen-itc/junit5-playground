package de.loewenitc.extension;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Mug {

    private MugType mugType;

    private String color;

    private String randomName;

}
