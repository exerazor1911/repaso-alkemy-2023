package com.alkemy.icons.icons.dtos.responses;

import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public class CountryResponseDTO {

    private Long id;

    private String image;

    private String denomination;

    private Long inhabitantsQuantity;

    private double totalSurfaceInSquaredMeters;

    private List<IconResponseDTO> icons;

    private ContinentResponseDTO continent;
}
