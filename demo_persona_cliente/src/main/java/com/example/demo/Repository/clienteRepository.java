package com.example.demo.Repository;

import com.example.demo.DTO.clienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.Constants.statusCliente;

import java.util.List;

@Repository
public interface clienteRepository extends JpaRepository<clienteDTO, Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM Cliente WHERE status = ?1 ")
    List<clienteDTO> getAllClientsByStatus(String status);

    @Query(nativeQuery = true, value = "SELECT status FROM status WHERE status = ?1")
    String getStatus(String status);


}
