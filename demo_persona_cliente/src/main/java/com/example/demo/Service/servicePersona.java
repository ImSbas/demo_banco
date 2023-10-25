package com.example.demo.Service;

import com.example.demo.Domain.Cliente;
import com.example.demo.Domain.Reporte;
import com.example.demo.Repository.clienteRepository;
import com.example.demo.Repository.reporteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class servicePersona {

    @Autowired
    private clienteRepository repository;

    @Autowired
    private reporteRepository reporteRepository;

    private hashService hashService = new hashService();

    public List<Cliente> getAllClients() {
        try {
            List<Cliente> clienteList = repository.getAllClients();
            return clienteList;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public Boolean addClient(Cliente cliente) {
        try{
            cliente.setStatus(1);
            String hashed = hashService.hashString(cliente.getPassword());
            cliente.setPassword(hashed);
            repository.save(cliente);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }
    public Boolean deleteClient(Integer id) {
        try{
            Cliente cliente = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
            System.out.println("aqui llegov ->" + cliente.getId());
            cliente.setStatus(2);
            this.repository.save(cliente);
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public Boolean updateClient(Integer id, Cliente cliente) {
        try{
            Cliente clienteFinded = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

            Integer status = this.repository.getStatus(cliente.getStatus());

            clienteFinded.setName(cliente.getName());
            clienteFinded.setDirection(cliente.getDirection());
            clienteFinded.setTelephone(cliente.getTelephone());
            if(!cliente.getPassword().isEmpty() || !cliente.getPassword().isBlank())
                clienteFinded.setPassword(hashService.hashString(cliente.getPassword()));
            if(status == null) status = clienteFinded.getStatus();
            clienteFinded.setStatus(status);
            this.repository.save(clienteFinded);
            return true;

        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;

        }
    }

    public List<Reporte> getReport(String firstDate, String lastDate, String id) {
        try{
            List<Reporte>report =  reporteRepository.getReport(firstDate, lastDate, id);
            return report;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }


}
