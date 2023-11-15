package com.example.demo.Domain;

import com.example.demo.DTO.reporteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reporte {

    private String fechas;

    private Integer valores;

    private String card;

    public Reporte(String fechas, Integer valores, String card) {
        this.fechas = fechas;
        this.valores = valores;
        this.card = card;
    }

    public Reporte() {
    }

    public Reporte(reporteDTO reporteDTO) {
        this.fechas = reporteDTO.getFechas();
        this.card = reporteDTO.getCard();
        this.valores = reporteDTO.getValores();
    }
}
