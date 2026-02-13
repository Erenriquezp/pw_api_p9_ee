package uce.edu.web.api.app.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
@SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
public class Vehiculo {
    @Id
    public Long id;

    public String modelo;
    public String chasis;
    public LocalDate fechaFabricacion;
    public LocalDate fechaMatricula;
}
