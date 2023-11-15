package com.example.demo.ControllerCliente;

import com.example.demo.Domain.Cliente;
import com.example.demo.Service.servicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/client")
public class controllerCliente {

    @Autowired
    servicePersona service;

    @GetMapping(path = "/list")
    public List<Cliente> getClients() {
        try {
            return service.getAllClients();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @PostMapping(path = "/new")
    public ResponseEntity<?> newClient(@RequestBody Cliente newCliente){
        try{
            if(this.service.addClient(newCliente))
                return new ResponseEntity<>("added succesfully", HttpStatus.OK);
            else
                return new ResponseEntity<>("couldn't add person", HttpStatus.FORBIDDEN);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>("couldn't add person", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Integer id, @RequestBody Cliente updated){
        try{
            if(this.service.updateClient(id,updated))
                return new ResponseEntity<>("updated person", HttpStatus.OK);
            return new ResponseEntity<>("couldn't update person", HttpStatus.FORBIDDEN);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>("couldn't update person", HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Integer id){
        try{
            if(!this.service.deleteClient(id)) return new ResponseEntity<>("couldn't delete person", HttpStatus.FORBIDDEN);
            return new ResponseEntity<>("person deleted succesfully", HttpStatus.OK);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return new ResponseEntity<>("couldn't delete person", HttpStatus.FORBIDDEN);
        }
    }


}
