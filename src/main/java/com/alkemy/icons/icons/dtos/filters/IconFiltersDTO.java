package com.alkemy.icons.icons.dtos.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class IconFiltersDTO {
    private String name;
    private String date;
    private Set<Long> cities;
    private String order;

    public boolean isASC() {return this.order.equalsIgnoreCase("ASC");}
    public boolean isDESC() {return this.order.equalsIgnoreCase("DESC");}

}
