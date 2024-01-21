package io.github.quinnandrews.spring.local.example.web.rest.guitarpedals;

import io.github.quinnandrews.spring.local.example.service.guitarpedals.GuitarPedalService;
import io.github.quinnandrews.spring.local.example.web.rest.guitarpedals.response.GuitarPedalResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/guitar-pedals")
@RestController
public class GuitarPedalController {

    private final GuitarPedalService guitarPedalService;

    public GuitarPedalController(final GuitarPedalService guitarPedalService) {
        this.guitarPedalService = guitarPedalService;
    }

    @GetMapping
    public List<GuitarPedalResponse> getAllGuitarPedals() {
        return guitarPedalService.findAllGuitarPedals().stream()
                .map(GuitarPedalResponse::from)
                .toList();
    }
}
