package com.example.demo.Mappers;

import com.example.demo.Constants.statusCuenta;
import com.example.demo.Constants.tipoCuenta;
import com.example.demo.DTO.cuentaDTO;
import com.example.demo.Domain.Cuenta;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class cuentaMapper {

    public cuentaDTO cuentaToDto(Cuenta cuenta) {
        cuentaDTO cuentaDTO = new cuentaDTO();
        cuentaDTO.setNumber(cuenta.getNumber());
        cuentaDTO.setOwner(cuenta.getOwner());
        cuentaDTO.setTipoCuenta(cuenta.getTipoCuenta().getDescripcion());
        cuentaDTO.setStatus(cuenta.getStatus().getDescripcion());
        cuentaDTO.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaDTO.setSaldo(cuenta.getSaldo());
        return cuentaDTO;
    }

    public Cuenta dtoToCuenta(cuentaDTO cuentaDTO) {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumber(cuentaDTO.getNumber());
        cuenta.setOwner(cuentaDTO.getOwner());
        cuenta.setTipoCuenta(tipoCuenta.fromDescripcion(cuentaDTO.getTipoCuenta()));
        cuenta.setStatus(statusCuenta.fromDescripcion(cuentaDTO.getStatus()));
        cuenta.setSaldoInicial(cuentaDTO.getSaldoInicial());
        cuenta.setSaldo(cuentaDTO.getSaldo());
        return cuenta;
    }
}
