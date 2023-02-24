package com.alkemy.icons.icons.repositories.specification;

import com.alkemy.icons.icons.dtos.filters.IconFiltersDTO;
import com.alkemy.icons.icons.entities.CountryEntity;
import com.alkemy.icons.icons.entities.IconEntity;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class IconSpecification {

    public Specification<IconEntity> getByFilters(IconFiltersDTO filtersDTO) {
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

            if (StringUtils.hasLength(filtersDTO.getDate())) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate date = LocalDate.parse(filtersDTO.getDate(), formatter);

                predicates.add(
                        criteriaBuilder.equal(root.get("creationDate"), date)
                );
            }

            if (!CollectionUtils.isEmpty(filtersDTO.getCities())) {
                Join<CountryEntity, IconEntity> join = root.join("countries", JoinType.INNER);
                Expression<String> citiesID = join.get("id");
                predicates.add(citiesID.in(filtersDTO.getCities()));
            }


            query.distinct(true);

            String orderByField = "denomination";
            query.orderBy(
                    filtersDTO.isASC() ? criteriaBuilder.asc(root.get(orderByField)) : criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }

}
