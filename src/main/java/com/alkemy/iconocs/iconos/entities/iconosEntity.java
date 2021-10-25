package com.alkemy.iconocs.iconos.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icono")
@Getter
@Setter
@EqualsAndHashCode
public class iconosEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    @Column( name = "fecha_creacion")
    @DateTimeFormat(
            pattern = "yyyy/MM/dd"
    )
    private LocalDate fechaCreacion;


    private String altura;
    private String historia;

    @ManyToMany(
            mappedBy = "iconos",
            cascade = CascadeType.ALL
    )
    private List<paisEntity> paises = new ArrayList<>();

    //ADD and REMOVE paises

    public void addPais(paisEntity pais) { this.paises.add(pais);}

    public void removePais(paisEntity pais) { this.paises.remove(pais);}

}
