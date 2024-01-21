package io.github.quinnandrews.spring.local.example.service.guitarpedals;

import io.github.quinnandrews.spring.data.specification.builder.SpecificationBuilder;
import io.github.quinnandrews.spring.local.example.data.guitarpedals.GuitarPedal;
import io.github.quinnandrews.spring.local.example.data.guitarpedals.GuitarPedal_;
import io.github.quinnandrews.spring.local.example.data.guitarpedals.repository.GuitarPedalRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarPedalService {

    private final GuitarPedalRepository guitarPedalRepository;

    public GuitarPedalService(final GuitarPedalRepository guitarPedalRepository) {
        this.guitarPedalRepository = guitarPedalRepository;
    }

    public List<GuitarPedal> findAllGuitarPedals() {
        return guitarPedalRepository.findAll(
                SpecificationBuilder.withRoot(GuitarPedal.class)
                        .withFetch(GuitarPedal_.manufacturer)
                        .withFetch(GuitarPedal_.tags)
                        .toSpecification(),
                Sort.by(Sort.Order.desc(GuitarPedal_.DATE_SOLD),
                        Sort.Order.asc(GuitarPedal_.NAME))
        );
    }
}
