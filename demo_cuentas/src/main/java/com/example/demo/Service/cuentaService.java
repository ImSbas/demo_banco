package com.example.demo.Service;

import com.example.demo.DTO.cuentaDTO;
import com.example.demo.Constants.statusCuenta;
import com.example.demo.Domain.Cuenta;
import com.example.demo.Domain.Reporte;
import com.example.demo.Mappers.cuentaMapper;
import com.example.demo.Mappers.reporteMapper;
import com.example.demo.Repository.cuentaRepository;
import com.example.demo.Repository.movimientoRepository;
import com.example.demo.Repository.reporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class cuentaService {

    @Autowired
    cuentaRepository cuentaRepository;

    @Autowired
    reporteRepository reporteRepository;

    @Autowired
    hashService hashService;

    @Autowired
    movimientoRepository movimientoRepository;

    @Autowired
    cuentaMapper cuentaMapper;

    @Autowired
    reporteMapper reporteMapper;

    public List<Cuenta> getAllCuentas(){
        try{
            List<Cuenta> cuentas = new ArrayList<>();
            cuentaRepository.getAllActiveCuentas().stream().forEach( cuentaDTO -> {
                cuentas.add(cuentaMapper.dtoToCuenta(cuentaDTO));
            });
            return cuentas;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public Cuenta createCuenta(Cuenta cuenta){
        try{
            cuenta.setStatus(statusCuenta.ACTIVO);
            String hashedNumber = hashService.hashString(cuenta.getNumber());
            cuentaDTO cuentaDTO = this.cuentaRepository.verifiyExistence(hashedNumber);
            if(cuentaDTO != null){ return null;}
            cuenta.setNumber(hashedNumber);
            cuentaRepository.save(cuentaMapper.cuentaToDto(cuenta));
            return cuenta;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public Cuenta deleteCuenta(String number){
        try{
            String hashedNumber = hashService.hashString(number);
            Cuenta findedCuenta = cuentaMapper.dtoToCuenta(cuentaRepository.getCuentaByNumber(hashedNumber));
            findedCuenta.setStatus(statusCuenta.INACTIVO);
            cuentaRepository.save(new cuentaDTO(findedCuenta));
            return findedCuenta;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public Cuenta updateCuenta(String number, Cuenta cuenta) throws Exception{
        try{
            Integer type;
            String hashedNumber = hashService.hashString(number);
            Cuenta findedCuenta = cuentaMapper.dtoToCuenta(cuentaRepository.getCuentaByNumber(hashedNumber));
            if(cuenta.getTipoCuenta() != null)
                findedCuenta.setTipoCuenta(cuenta.getTipoCuenta());
            if(cuenta.getStatus() != null)
                findedCuenta.setStatus(cuenta.getStatus());
            cuentaRepository.save(new cuentaDTO(findedCuenta));
            return findedCuenta;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public List<Reporte> getReport(String firstDate, String lastDate, String id) {
        try{
            List<Reporte>report = new ArrayList<>();
            reporteRepository.getReport(firstDate, lastDate, id).stream().forEach(reporteDTO -> {
                report.add(reporteMapper.dtoToReporte(reporteDTO));
            });
            return report;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

}
