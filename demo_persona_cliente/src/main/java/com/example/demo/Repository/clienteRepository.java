package com.example.demo.Repository;

import com.example.demo.Domain.Cliente;
import com.example.demo.Domain.Persona;
import com.example.demo.Domain.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM Cliente WHERE status = 1")
    List<Cliente> getAllClients();

    @Query(nativeQuery = true, value = "SELECT id_status FROM status WHERE id_status = ?1")
    Integer getStatus(Integer id);


}
