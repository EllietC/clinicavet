package cl.udp.veterinaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.udp.veterinaria.entity.ClientesEntity;
import cl.udp.veterinaria.services.ClientesServices;
import jakarta.transaction.Transactional;

@RestController
public class ClienteController {
    @Autowired()
    private ClientesServices clienteService;

    @RequestMapping(value = "/cliente/", method = RequestMethod.GET)
    public ResponseEntity<?> get(@RequestParam(value = "rut", required = false) String rut) {
        try {
            if (rut == null) {
                return new ResponseEntity<>(clienteService.getClientes(), HttpStatusCode.valueOf(200));
            }
            return new ResponseEntity<ClientesEntity>(clienteService.getCliente(rut), HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Exception>(e, HttpStatusCode.valueOf(500));
        }
    }

    @RequestMapping(value = "/cliente/", method = RequestMethod.POST)
    public ResponseEntity<?> addCliente(@RequestBody ClientesEntity cliente) {
        try {
            return new ResponseEntity<ClientesEntity>(clienteService.saveCliente(cliente), HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Exception>(e, HttpStatusCode.valueOf(500));
        }
    }

    @Transactional
    @RequestMapping(value = "/cliente/", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCliente(@RequestParam("rut") String rut) {
        try {
            clienteService.deleteCliente(rut);
            return new ResponseEntity<String>("El cliente fue eliminado exitosamente",HttpStatusCode.valueOf(200));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(e.getMessage(), HttpStatusCode.valueOf(500));
        }
    }

}
