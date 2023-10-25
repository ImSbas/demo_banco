package com.example.demo.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cuenta {

    @Id
    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private Integer tipoCuenta;

    @Column(name = "balance")
    private Integer saldoInicial;

    @Column(name = "status_id")
    private Integer status;

    @Column(name = "owner_id")
    private Integer owner;

}
