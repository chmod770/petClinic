package gabi.clinic.demo.repositories;

import gabi.clinic.demo.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long>{
}
