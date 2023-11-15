package com.example.demo.DTO;


import com.example.demo.Domain.Cuenta;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cuenta")
public class cuentaDTO {

    @Id
    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private String tipoCuenta;

    @Column(name = "balance")
    private Integer saldoInicial;

    @Column(name = "status")
    private String status;

    @Column(name = "owner_id")
    private Integer owner;

    public cuentaDTO(String number) {
        this.number = number;
    }

    public cuentaDTO(Cuenta cuenta) {
        this.number = cuenta.getNumber();
        this.owner = cuenta.getOwner();
        this.tipoCuenta = cuenta.getTipoCuenta().getDescripcion();
        this.status = cuenta.getStatus().getDescripcion();
        this.saldoInicial = cuenta.getSaldoInicial();
    }

    public cuentaDTO(){}
}
