package com.alkemy.icons.icons.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
@Setter
@Getter
@SQLDelete(sql = "UPDATE country SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    private String denomination;

    @Column(name = "inhabitants_quantity")
    private Long inhabitantsQuantity;

    @Column(name = "total_surface")
    private double totalSurfaceInSquaredMeters;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "icon_country",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id")
    )
    private Set<IconEntity> icons = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continent_id", insertable = false, updatable = false)
    private ContinentEntity continent;

    @Column(name = "continent_id", nullable = false)
    private Long continentId;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final CountryEntity other = (CountryEntity) obj;

        return other.id == this.id;
    }

    private boolean deleted = Boolean.FALSE;
}
