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

@Service
@Transactional
public class movimientoService {

    @Autowired
    movimientoRepository movimientoRepository;

    @Autowired
    cuentaRepository cuentaRepository;

    hashService hashService = new hashService();

    public List<Movimiento> getAllMovimiento(String cardNumber){
        try{
            return movimientoRepository.getAllMovimientosByCard(hashService.hashString(cardNumber));
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public String registerMovimiento(Integer valor, String card){
        try{
            Integer type;
            String hashedNumber = hashService.hashString(card);
            Cuenta findedCuenta = cuentaRepository.getCuentaByNumber(hashedNumber);
            if(findedCuenta.getSaldoInicial() < Math.abs(valor)){
                //return throw new Exception("not founds enought to execute operation, recharge your account");
                return "not founds enought to execute operation, recharge your account";
            }
            findedCuenta.setSaldoInicial(findedCuenta.getSaldoInicial() + valor);
            if (valor<0)
                type = 2;
            else
                type = 1;
            cuentaRepository.save(findedCuenta);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            movimientoRepository.save(new Movimiento(
                    strDate, type, valor, findedCuenta.getNumber()
            ));
            return "succesfull";
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return "denied";
        }
    }


    public List<Movimiento> getReport(String firstDate, String lastDate, String card) {
        try{
            String hashed = hashService.hashString(card);
            List<Movimiento>report =  movimientoRepository.getReport(firstDate, lastDate, hashed);
            return report;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
