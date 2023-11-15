package com.example.demo.Domain;

import com.example.demo.DTO.movimientoDTO;
import com.example.demo.Constants.tipoMovimiento;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Movimiento {

    private Integer id;

    private String fecha;

    private tipoMovimiento tipoMovimiento;

    private Integer valor;

    private String cardNumber;

    public Movimiento(String fecha, tipoMovimiento tipoMovimiento, Integer valor, String cardNumber) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.cardNumber = cardNumber;
    }

    public Movimiento(movimientoDTO movimientoDTO){
        this.fecha = movimientoDTO.getFecha();
        this.tipoMovimiento = com.example.demo.Constants.tipoMovimiento.fromDescripcion(movimientoDTO.getTipoMovimiento());
        this.valor = movimientoDTO.getValor();
        this.cardNumber = movimientoDTO.getCardNumber();
        this.id = movimientoDTO.getId();
    }

    public Movimiento() {}
}
