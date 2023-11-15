package com.example.demo.Domain;

import com.example.demo.DTO.cuentaDTO;
import com.example.demo.Constants.statusCuenta;
import com.example.demo.Constants.tipoCuenta;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Cuenta {

    private String number;

    private tipoCuenta tipoCuenta;

    private Integer saldoInicial;

    private statusCuenta status;

    private Integer owner;

    public Cuenta(String number) {
        this.number = number;
    }

    public Cuenta(cuentaDTO cuentaDTO) {
        this.number = cuentaDTO.getNumber();
        this.owner = cuentaDTO.getOwner();
        this.tipoCuenta = com.example.demo.Constants.tipoCuenta.fromDescripcion(cuentaDTO.getTipoCuenta());
        this.status = statusCuenta.fromDescripcion(cuentaDTO.getStatus());
        this.saldoInicial = cuentaDTO.getSaldoInicial();
    }

    public Cuenta() {
    }
}
