package com.alkemy.icons.icons.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
public class IconRequestDTO {

    private String image;

    private String denomination;

    private double height;

    private String history;

    private Set<CountryRequestDTO> countries;

}
