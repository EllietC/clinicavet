package cl.udp.veterinaria.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class ClientesEntity {
    @Id
    String rut;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    Integer comuna_id;

}
