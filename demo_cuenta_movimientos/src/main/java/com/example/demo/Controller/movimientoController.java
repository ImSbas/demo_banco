package com.example.demo.Controller;

import com.example.demo.Domain.Cuenta;
import com.example.demo.Domain.Movimiento;
import com.example.demo.Service.movimientoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movimientos")
public class movimientoController {

    @Autowired
    movimientoService service;

    @GetMapping(path = "/list/{number}")
    public List<Movimiento> getAllMovimientos(@PathVariable String number){
        try{
            return service.getAllMovimiento(number);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> registerMovimiento(@RequestParam Integer valor, String card){
        try{
            String result = service.registerMovimiento(valor, card);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>("not created succesfully", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/report")
    public List<Movimiento> getReport(@RequestParam String firstDate, @RequestParam String lastDate, @RequestParam String card){
        try{
            List<Movimiento> result = service.getReport(firstDate, lastDate, card);
            return result;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }


}
