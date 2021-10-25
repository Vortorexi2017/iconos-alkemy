package com.alkemy.iconocs.iconos.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "pais")
@Getter
@Setter
@EqualsAndHashCode
public class paisEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    @Column( name = "cantidad_habitantes")
    private String cantidadHabitantes;

    @Column( name = "superficie_total")
    private String superficieTotal;

    //ESTE ME TRAE EL CONTINENTE(SOLO INFO)
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "continente_id",
            insertable = false,
            updatable = false
    )
    private continenteEntity continente;


    //ESTE GUARDA Y ACTUALIZA
    @Column(
            name = "continente_id",
            nullable = false
    )
    private Long continenteId;


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "icono_pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icono_id")
    )
    private Set<iconosEntity> iconos = new HashSet<>();
}
