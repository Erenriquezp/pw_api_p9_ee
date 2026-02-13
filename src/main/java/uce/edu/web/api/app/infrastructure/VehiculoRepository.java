package uce.edu.web.api.app.infrastructure;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.web.api.app.domain.Vehiculo;

@ApplicationScoped
public class VehiculoRepository implements PanacheRepository<Vehiculo> {
    
}
