package com.example.demo.Service;

import com.example.demo.Domain.Cuenta;
import com.example.demo.Domain.Movimiento;
import com.example.demo.Repository.cuentaRepository;
import com.example.demo.Repository.movimientoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class cuentaService {

    @Autowired
    cuentaRepository cuentaRepository;

    hashService hashService = new hashService();

    @Autowired
    movimientoRepository movimientoRepository;

    public List<Cuenta> getAllCuentas(){
        try{
            return cuentaRepository.getAllActiveCuentas();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public Boolean createCuenta(Cuenta cuenta){
        try{
            cuenta.setNumber(hashService.hashString(cuenta.getNumber()));
            cuentaRepository.save(cuenta);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public Boolean deleteCuenta(String number){
        try{
            String hashedNumber = hashService.hashString(number);
            Cuenta findedCuenta = cuentaRepository.getCuentaByNumber(hashedNumber);
            System.out.println("aqui llego" + findedCuenta.getNumber());
            findedCuenta.setStatus(2);
            cuentaRepository.save(findedCuenta);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public Boolean updateCuenta(String number, Cuenta cuenta) throws Exception{
        try{
            Integer type;
            String hashedNumber = hashService.hashString(number);
            Cuenta findedCuenta = cuentaRepository.getCuentaByNumber(hashedNumber);
            if(cuenta.getTipoCuenta() != null)
                findedCuenta.setTipoCuenta(cuenta.getTipoCuenta());
            if(cuenta.getStatus() != null)
                findedCuenta.setStatus(cuenta.getStatus());
            cuentaRepository.save(findedCuenta);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

}
