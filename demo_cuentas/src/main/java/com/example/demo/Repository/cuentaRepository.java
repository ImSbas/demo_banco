package com.example.demo.Repository;

import com.example.demo.DTO.cuentaDTO;
import com.example.demo.Domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cuentaRepository extends JpaRepository<cuentaDTO, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM cuenta where status = 'Activo'")
    List<cuentaDTO> getAllActiveCuentas();

    @Query(nativeQuery = true, value = "SELECT number, type, balance,initial_balance, status, owner_id FROM cuenta where status = 'Activo' and number = ?1")
    cuentaDTO getCuentaByNumber(String number);

    @Query(nativeQuery = true, value = "SELECT number, type, balance,initial_balance, status, owner_id FROM cuenta where number = ?1")
    cuentaDTO verifiyExistence(String number);

}
