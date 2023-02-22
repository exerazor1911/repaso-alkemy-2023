package com.alkemy.icons.icons.repositories;

import com.alkemy.icons.icons.entities.IconEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long> {
}
