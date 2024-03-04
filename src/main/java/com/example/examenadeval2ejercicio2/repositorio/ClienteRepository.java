package com.example.examenadeval2ejercicio2.repositorio;

import com.example.examenadeval2ejercicio2.enumerado.Estado;
import com.example.examenadeval2ejercicio2.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente getClienteById (Integer id);

    @Query("SELECT c FROM Cliente c WHERE c.ventas > :ventas")
    List<Cliente> getClienteByVentasMayoresQue(@Param("ventas") Integer ventas);


}
