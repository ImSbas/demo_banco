package com.example.demo.DTO;

import com.example.demo.Domain.Reporte;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class reporteDTO {

    @Id
    @Column(name= "fechas")
    private String fechas;

    @Column(name = "valores")
    private Integer valores;

    @Column(name = "cards")
    private String card;

    public reporteDTO(String fechas, Integer valores, String card) {
        this.fechas = fechas;
        this.valores = valores;
        this.card = card;
    }

    public reporteDTO() {
    }

}
