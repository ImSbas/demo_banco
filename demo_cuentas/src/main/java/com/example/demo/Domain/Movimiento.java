package com.example.demo.Domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true)
    private Integer id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "type_id")
    private Integer tipoMovimiento;

    @Column(name = "value")
    private Integer valor;

    @Column(name = "card")
    private String cardNumber;

    public Movimiento(String fecha, Integer tipoMovimiento, Integer valor, String cardNumber) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.cardNumber = cardNumber;
    }

    public Movimiento() {

    }
}
