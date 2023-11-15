package com.example.demo.Service;

import com.example.demo.Constants.statusCliente;
import com.example.demo.Domain.Cliente;
import com.example.demo.Mapper.clienteMapper;
import com.example.demo.Repository.clienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class servicePersona {

    @Autowired
    private clienteRepository repository;

    @Autowired
    private clienteMapper clienteMapper;

    @Autowired
    private hashService hashService;

    public List<Cliente> getAllClients() {
        try {
            //List<Cliente> clienteList = repository.getAllClients();
            List<Cliente> clienteList = new ArrayList<>();
            repository.getAllClientsByStatus(statusCliente.ACTIVO.getDescripcion()).stream().forEach(clienteDTO -> {
                clienteList.add(clienteMapper.dtoToCliente(clienteDTO));
            });
            return clienteList;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public Boolean addClient(Cliente cliente) {
        try{
            if(this.repository.findById(cliente.getId()).isPresent()) return false;
            cliente.setStatus(statusCliente.ACTIVO);
            String hashed = hashService.hashString(cliente.getPassword());
            cliente.setPassword(hashed);
            repository.save(clienteMapper.clienteToDTO(cliente));
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }
    public Boolean deleteClient(Integer id) {
        try{
            //Cliente cliente = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
            Cliente cliente = clienteMapper.dtoToCliente(this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id)));
            System.out.println("aqui llegov ->" + cliente.getId());
            cliente.setStatus(statusCliente.INACTIVO);
            this.repository.save(clienteMapper.clienteToDTO(cliente));
            return true;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public Boolean updateClient(Integer id, Cliente cliente) {
        try{
            //Cliente clienteFinded = this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
            Cliente clienteFinded = clienteMapper.dtoToCliente(this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id)));

            clienteFinded.setName(cliente.getName());
            clienteFinded.setDirection(cliente.getDirection());
            clienteFinded.setTelephone(cliente.getTelephone());
            if(!cliente.getPassword().isEmpty() || !cliente.getPassword().isBlank())
                clienteFinded.setPassword(hashService.hashString(cliente.getPassword()));
            clienteFinded.setStatus(cliente.getStatus());
            this.repository.save(clienteMapper.clienteToDTO(clienteFinded));
            return true;

        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return false;

        }
    }


}
