package de.loewenitc.extension;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MugRestController {

    private final MugService mugService;

    @GetMapping("/mug")
    public Mug mugs(
            @RequestParam(value = "mugType", defaultValue="ESPRESSO") MugType mugType,
            @RequestParam(value = "color") String color,
            @RequestParam(value = "name_length") int length) {
        return mugService.createMug(mugType, color, length);
    }
}
