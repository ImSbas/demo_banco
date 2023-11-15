package com.example.demo.Service;

import com.example.demo.DTO.cuentaDTO;
import com.example.demo.DTO.movimientoDTO;
import com.example.demo.Constants.tipoMovimiento;
import com.example.demo.Domain.Cuenta;
import com.example.demo.Domain.Movimiento;
import com.example.demo.Mappers.cuentaMapper;
import com.example.demo.Mappers.movimientoMapper;
import com.example.demo.Repository.cuentaRepository;
import com.example.demo.Repository.movimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    hashService hashService;

    @Autowired
    movimientoMapper movimientoMapper;

    @Autowired
    cuentaMapper cuentaMapper;

    public List<Movimiento> getAllMovimiento(String cardNumber){
        try{
            List<Movimiento> movimientos = new ArrayList<>();
            movimientoRepository.getAllMovimientosByCard(hashService.hashString(cardNumber)).stream().forEach(movimientoDTO -> {
                movimientos.add(movimientoMapper.dtoToMovimiento(movimientoDTO));
            });
            return movimientos;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public String registerMovimiento(Integer valor, String card){
        try{
            String type;
            String hashedNumber = hashService.hashString(card);
            Cuenta findedCuenta = cuentaMapper.dtoToCuenta(cuentaRepository.getCuentaByNumber(hashedNumber));
            if(findedCuenta.getSaldoInicial() < Math.abs(valor) && valor < 0){
                return "not founds enought to execute operation, recharge your account";
            }
            findedCuenta.setSaldoInicial(findedCuenta.getSaldoInicial() + valor);
            if (valor<0)
                type = tipoMovimiento.RETIRO.getDescripcion();
            else
                type = tipoMovimiento.ABONO.getDescripcion();
            cuentaRepository.save(new cuentaDTO(findedCuenta));
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            movimientoRepository.save(new movimientoDTO(
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
            List<Movimiento>report = new ArrayList<>();
            movimientoRepository.getReport(firstDate, lastDate, hashed).stream().forEach(movimientoDTO -> {
                report.add(movimientoMapper.dtoToMovimiento(movimientoDTO));
            });
            return report;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
