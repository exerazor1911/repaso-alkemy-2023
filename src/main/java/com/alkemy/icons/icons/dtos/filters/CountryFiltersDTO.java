package com.alkemy.icons.icons.dtos.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CountryFiltersDTO {

    private String name;

    private Long continentId;

    private String order;

    public boolean isASC() {return this.order.equalsIgnoreCase("ASC");}

    public boolean isDESC() {return this.order.equalsIgnoreCase("DESC");}

}
