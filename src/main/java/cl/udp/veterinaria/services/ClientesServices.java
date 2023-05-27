package cl.udp.veterinaria.services;

import java.util.ArrayList;

import cl.udp.veterinaria.entity.ClientesEntity;

public interface ClientesServices {
    public ClientesEntity getCliente(String rut);
    public ArrayList<ClientesEntity> getClientes();
    public ClientesEntity saveCliente(ClientesEntity cliente);
    public void deleteCliente(String rut);
}
