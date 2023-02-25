package com.alkemy.icons.icons.repositories;

import com.alkemy.icons.icons.entities.CountryEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {

    List<CountryEntity> findAll(Specification<CountryEntity> spec);
}
