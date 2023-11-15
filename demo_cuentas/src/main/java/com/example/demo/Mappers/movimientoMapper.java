package com.example.demo.Mappers;

import com.example.demo.DTO.movimientoDTO;
import com.example.demo.Domain.Movimiento;
import org.springframework.stereotype.Service;


@Service
public class movimientoMapper {

    public Movimiento dtoToMovimiento(movimientoDTO movimientoDTO){
        Movimiento movimiento = new Movimiento();
        movimiento.setFecha( movimientoDTO.getFecha());
        movimiento.setTipoMovimiento(com.example.demo.Constants.tipoMovimiento.fromDescripcion(movimientoDTO.getTipoMovimiento()));
        movimiento.setValor(movimientoDTO.getValor());
        movimiento.setCardNumber(movimientoDTO.getCardNumber());
        movimiento.setId(movimientoDTO.getId());
        return movimiento;
    }
}
