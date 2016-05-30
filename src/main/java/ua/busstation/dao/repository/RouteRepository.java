package ua.busstation.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ua.busstation.dao.models.RouteModel;

public interface RouteRepository extends CrudRepository<RouteModel, String>{

    RouteModel findByName(String name);
}
