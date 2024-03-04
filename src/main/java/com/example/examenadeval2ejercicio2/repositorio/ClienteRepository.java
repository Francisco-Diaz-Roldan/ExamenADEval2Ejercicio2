package com.example.examenadeval2ejercicio2.repositorio;

import com.example.examenadeval2ejercicio2.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente getClienteById (Integer id);

    @Query("SELECT c FROM Cliente c WHERE c.ventas > :ventas")
    List<Cliente> getClienteByVentasMayoresQue(@Param("ventas") Integer ventas);

    @Query("SELECT COALESCE(SUM(c.ventas), 0) FROM Cliente c")
    Integer getTotalVentasClientes();

    @Query("SELECT COALESCE(AVG(c.ventas), 0.0) FROM Cliente c WHERE c.estado = 'activo'")
    Float getPromedioVentasClientesActivos();

    @Query("SELECT COUNT(c) FROM Cliente c WHERE c.estado = 'inactivo' AND c.ventas > 0")
    Integer getTotalClientesInactivosConVentasPositivas();

}
