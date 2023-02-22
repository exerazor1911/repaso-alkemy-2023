package com.alkemy.icons.icons.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CountryRequestDTO {

    private String image;

    private String denomination;

    private Long inhabitantsQuantity;

    private double totalSurfaceInSquaredMeters;

    private Set<IconRequestDTO> icons;

    private ContinentRequestDTO continent;

}
