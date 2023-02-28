package com.alkemy.icons.icons.repositories.specification;

import com.alkemy.icons.icons.dtos.filters.CountryFiltersDTO;
import com.alkemy.icons.icons.entities.CountryEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountrySpecification {

    public Specification<CountryEntity> getByFilters(CountryFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denomination")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if (!ObjectUtils.isEmpty(filtersDTO.getContinentId())) {
                predicates.add(
                        criteriaBuilder.equal(root.get("continent"), filtersDTO.getContinentId())
                );
            }

            query.distinct(true);

            String orderByField = "denomination";
            query.orderBy(
                    filtersDTO.isASC() ? criteriaBuilder.asc(root.get(orderByField)) : criteriaBuilder.desc(root.get(orderByField))
            );

            return  criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }
}
