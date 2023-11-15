package com.example.demo.Mappers;

import com.example.demo.DTO.reporteDTO;
import com.example.demo.Domain.Reporte;
import org.springframework.stereotype.Service;

@Service
public class reporteMapper {

    public Reporte dtoToReporte(reporteDTO reporteDTO){
        Reporte reporte = new Reporte();
        reporte.setCard(reporteDTO.getCard());
        reporte.setValores(reporteDTO.getValores());
        reporte.setFechas(reporteDTO.getFechas());
        return reporte;
    }

}
