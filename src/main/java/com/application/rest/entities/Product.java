package com.application.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="producto")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio")
    private BigDecimal price;

    //muchos products asosiados a un solo maker
    //@JoinColumn: Columna de la base de datos que se usará para unir las dos entidades
    //se usara id_fabricante del product como union con el maker
    @ManyToOne
    @JoinColumn(name = "id_fabricante", nullable = false)
    @JsonIgnore
    private Maker maker;
}
