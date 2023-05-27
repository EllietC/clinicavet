package cl.udp.veterinaria.services.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.udp.veterinaria.entity.ClientesEntity;
import cl.udp.veterinaria.repositories.ClienteRepository;
import cl.udp.veterinaria.services.ClientesServices;

@Service
public class ClientesServicesImp implements ClientesServices{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClientesEntity getCliente(String rut){
        ClientesEntity cliente = clienteRepository.findByRut(rut);
        return cliente;
    }

    @Override
    public ClientesEntity saveCliente(ClientesEntity cliente) {
        return clienteRepository.save(cliente);

    }

    @Override
    public void deleteCliente(String rut) {
        clienteRepository.deleteByRut(rut);
    }

    @Override
    public ArrayList<ClientesEntity> getClientes() {
        return (ArrayList<ClientesEntity>) clienteRepository.findAll();
    }
}
