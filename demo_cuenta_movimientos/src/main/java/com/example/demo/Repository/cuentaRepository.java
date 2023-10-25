package com.example.demo.Repository;

import com.example.demo.Domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cuentaRepository extends JpaRepository<Cuenta, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM cuenta where status_id = 1")
    List<Cuenta> getAllActiveCuentas();

    @Query(nativeQuery = true, value = "SELECT number, type, balance, status_id, owner_id FROM cuenta where status_id = 1 and number = ?1")
    Cuenta getCuentaByNumber(String number);

}
