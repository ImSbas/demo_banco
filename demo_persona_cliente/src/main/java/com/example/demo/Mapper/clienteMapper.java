package com.example.demo.Mapper;

import com.example.demo.Constants.statusCliente;
import com.example.demo.DTO.clienteDTO;
import com.example.demo.Domain.Cliente;
import org.springframework.stereotype.Service;

@Service
public class clienteMapper {

    public Cliente dtoToCliente(clienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setTelephone(clienteDTO.getTelephone());
        cliente.setPassword(clienteDTO.getPassword());
        cliente.setId(clienteDTO.getId());
        cliente.setName(clienteDTO.getName());
        cliente.setGender(clienteDTO.getGender());
        cliente.setIdentification(clienteDTO.getIdentification());
        cliente.setDirection(clienteDTO.getDirection());
        cliente.setDateOfBirth(clienteDTO.getDateOfBirth());
        cliente.setStatus(statusCliente.fromDescripcion(clienteDTO.getStatus()));
        return cliente;
    }

    public clienteDTO clienteToDTO(Cliente cliente){
        clienteDTO clienteDTO = new clienteDTO();
        clienteDTO.setTelephone(cliente.getTelephone());
        clienteDTO.setPassword(cliente.getPassword());
        clienteDTO.setId(cliente.getId());
        clienteDTO.setName(cliente.getName());
        clienteDTO.setGender(cliente.getGender());
        clienteDTO.setIdentification(cliente.getIdentification());
        clienteDTO.setDirection(cliente.getDirection());
        clienteDTO.setDateOfBirth(cliente.getDateOfBirth());
        clienteDTO.setStatus(cliente.getStatus().getDescripcion());
        return clienteDTO;
    }

}
