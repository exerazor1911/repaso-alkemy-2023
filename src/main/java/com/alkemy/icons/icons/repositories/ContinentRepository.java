package com.alkemy.icons.icons.repositories;

import com.alkemy.icons.icons.entities.ContinentEntity;
import com.alkemy.icons.icons.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity, Long> {

}
