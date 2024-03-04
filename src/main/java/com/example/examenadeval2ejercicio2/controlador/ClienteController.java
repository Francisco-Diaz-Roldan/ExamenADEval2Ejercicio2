package com.example.examenadeval2ejercicio2.controlador;

import com.example.examenadeval2ejercicio2.enumerado.Estado;
import com.example.examenadeval2ejercicio2.modelo.Cliente;
import com.example.examenadeval2ejercicio2.repositorio.ClienteRepository;
import com.example.examenadeval2ejercicio2.servicio.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SecurityService securityService;


    @GetMapping("/")
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }


    @GetMapping("/cliente/{id}")//Para todas las tiendas de un centro comercial
    public Cliente getCentroClienteById(@PathVariable Integer id) {
        return clienteRepository.getClienteById(id);
    }
    @GetMapping("/ventas-mayores-que/{ventas}")
    public List<Cliente> getClientesVentasMayoresQue(@PathVariable Integer ventas) {
        return clienteRepository.getClienteByVentasMayoresQue(ventas);
    }



    @PostMapping("/post")
    public ResponseEntity<Cliente> crearInformacionCliente(@RequestBody Cliente cliente,
                                                                      @RequestParam String token) {
        if (securityService.validarToken(token)) {
            Cliente nuevoCliente = clienteRepository.save(cliente);
            return new ResponseEntity<>(nuevoCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    //Todo hacer post, put y delete
}
