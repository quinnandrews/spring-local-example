package io.github.quinnandrews.spring.local.example.web.rest.guitarpedals.response;

import io.github.quinnandrews.spring.local.example.data.guitarpedals.GuitarPedal;
import io.github.quinnandrews.spring.local.example.data.guitarpedals.GuitarPedalTag;

import java.time.LocalDate;
import java.util.List;

public record GuitarPedalResponse(Long guitarPedalId,
                                  String guitarPedalName,
                                  Long manufacturerId,
                                  String manufacturerName,
                                  LocalDate datePurchased,
                                  LocalDate dateSold,
                                  Integer usedValue,
                                  List<String> tags) {

    public static GuitarPedalResponse from(final GuitarPedal guitarPedal) {
        return new GuitarPedalResponse(
                guitarPedal.getId(),
                guitarPedal.getName(),
                guitarPedal.getManufacturer().getId(),
                guitarPedal.getManufacturer().getName(),
                guitarPedal.getDatePurchased(),
                guitarPedal.getDateSold(),
                guitarPedal.getUsedValue(),
                guitarPedal.getTags().stream().map(GuitarPedalTag::getTag).toList()
        );
    }
}
