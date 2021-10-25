package com.alkemy.iconocs.iconos.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "continente")
@Getter
@Setter
@EqualsAndHashCode
public class continenteEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;
}
