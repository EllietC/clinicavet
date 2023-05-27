package cl.udp.veterinaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.udp.veterinaria.entity.ClientesEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClientesEntity, Integer>{
    public ClientesEntity findByRut(String rut);
    public void deleteByRut(String rut);
}
