package uce.edu.web.api.app.application;

import java.time.LocalDate;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.app.application.representation.VehiculoRepresentation;
import uce.edu.web.api.app.domain.Vehiculo;
import uce.edu.web.api.app.infrastructure.VehiculoRepository;

@ApplicationScoped
public class VehiculoService {
    @Inject
    VehiculoRepository repository;

    public List<VehiculoRepresentation> getAll() {
        return repository.listAll().stream().map(this::toRepresentation).toList();
    }

    public VehiculoRepresentation getById(Long id) {
        return this.toRepresentation((repository.findById(id)));
    }

    public void create(VehiculoRepresentation representation) {
        Vehiculo vehiculo = toEntity(representation);
        repository.persist(vehiculo);
    }

    private VehiculoRepresentation toRepresentation(Vehiculo vehiculo) {
        VehiculoRepresentation representation = new VehiculoRepresentation();
        representation.id = vehiculo.id;
        representation.modelo = vehiculo.modelo;
        representation.chasis = vehiculo.chasis;
        representation.fechaFabricacion = vehiculo.fechaFabricacion.toString();
        representation.fechaMatricula = vehiculo.fechaMatricula.toString();
        return representation;
    }

    private Vehiculo toEntity(VehiculoRepresentation representation) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.id = representation.id;
        vehiculo.modelo = representation.modelo;
        vehiculo.chasis = representation.chasis;
        vehiculo.fechaFabricacion = LocalDate.parse(representation.fechaFabricacion);
        vehiculo.fechaMatricula = LocalDate.parse(representation.fechaMatricula);
        return vehiculo;
    }
}
