package com.alkemy.icons.icons.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "continent")
@Setter
@Getter
@SQLDelete(sql = "UPDATE continent SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class ContinentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    private String denomination;

    private boolean deleted = Boolean.FALSE;
}
