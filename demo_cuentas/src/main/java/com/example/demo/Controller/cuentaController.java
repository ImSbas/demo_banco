package com.example.demo.Controller;

import com.example.demo.Domain.Cuenta;
import com.example.demo.Domain.Reporte;
import com.example.demo.Service.cuentaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cuentas")
public class cuentaController {

    @Autowired
    cuentaService service;
    
    @GetMapping(path = "/list")
    public List<Cuenta> getAllCuentas(){
        try{
            return service.getAllCuentas();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    
    @PostMapping(path = "/new")
    public ResponseEntity<?> createCuenta(@RequestBody Cuenta newCuenta){
        try{
            Cuenta cuenta = service.createCuenta(newCuenta);
            if(cuenta != null) return new ResponseEntity<>(cuenta, HttpStatus.OK);;
            return new ResponseEntity<>("not created succesfully", HttpStatus.FORBIDDEN);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>("not created succesfully", HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteCuenta(@RequestParam String number){
        try{
            Cuenta cuenta = service.deleteCuenta(number);
            if(cuenta != null) return new ResponseEntity<>(cuenta, HttpStatus.OK);;
            return new ResponseEntity<>("not deleted succesfully", HttpStatus.FORBIDDEN);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>("not deleted succesfully", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(path = "/{number}")
    public ResponseEntity<?> updateCuenta(@PathVariable String number, @RequestBody Cuenta cuenta){
        try{
            Cuenta cuentaUpdated = service.updateCuenta(number, cuenta);
            if(cuentaUpdated != null) return new ResponseEntity<>("updated succesfully", HttpStatus.OK);;
            return new ResponseEntity<>("not updated succesfully", HttpStatus.FORBIDDEN);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(path = "/report")
    public List<Reporte> getReport(@RequestParam String firstDate, @RequestParam String lastDate, @RequestParam String idClient){
        try{
            List<Reporte> result = service.getReport(firstDate, lastDate, idClient);
            return result;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

}
