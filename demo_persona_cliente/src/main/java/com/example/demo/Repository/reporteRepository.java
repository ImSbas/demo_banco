package com.example.demo.Repository;

import com.example.demo.Domain.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reporteRepository extends JpaRepository<Reporte, String> {
    @Query(value = "select cuenta.number as cards, movimiento.fecha as fechas, movimiento.value as valores from movimiento join cuenta on movimiento.card = cuenta.number join cliente on cuenta.owner_id = cliente.id  where movimiento.fecha between ?1 and ?2 and  cliente.id=?3" , nativeQuery = true)
    List<Reporte> getReport(String firstDate, String lastDate, String id);
}
