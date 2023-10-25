package com.example.demo.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Reporte {

    @Id
    @Column(name= "fechas")
    private String fechas;

    @Column(name = "valores")
    private Integer valores;

    @Column(name = "cards")
    private String card;

}
