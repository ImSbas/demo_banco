package com.example.demo.Repository;

import com.example.demo.Domain.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface movimientoRepository extends JpaRepository<Movimiento, Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM movimiento where card = ?1")
    List<Movimiento> getAllMovimientosByCard(String number);


    @Query(nativeQuery = true, value = "select * from movimiento where fecha between ?1 and ?2 and card =?3")
    List<Movimiento> getReport(String firstDate, String lastDate, String card);
}
