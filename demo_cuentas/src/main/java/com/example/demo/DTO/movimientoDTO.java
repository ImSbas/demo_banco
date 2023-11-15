package com.example.demo.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movimiento")
public class movimientoDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true)
    private Integer id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "type_id")
    private String tipoMovimiento;

    @Column(name = "value")
    private Integer valor;

    @Column(name = "card")
    private String cardNumber;

    public movimientoDTO(String fecha, String tipoMovimiento, Integer valor, String cardNumber) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.cardNumber = cardNumber;
    }

    public movimientoDTO() {

    }
}
