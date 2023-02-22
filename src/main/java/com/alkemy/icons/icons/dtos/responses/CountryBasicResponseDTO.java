package com.alkemy.icons.icons.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryBasicResponseDTO {

    private Long id;

    private String image;

    private String denomination;

    private Long inhabitantsQuantity;

}
