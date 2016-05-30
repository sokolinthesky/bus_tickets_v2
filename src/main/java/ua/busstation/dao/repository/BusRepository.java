package ua.busstation.dao.repository;

import org.springframework.data.repository.CrudRepository;
import ua.busstation.dao.models.BusModel;

public interface BusRepository extends CrudRepository<BusModel, String> {
}
