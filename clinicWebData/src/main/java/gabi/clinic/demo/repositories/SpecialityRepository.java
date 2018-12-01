package gabi.clinic.demo.repositories;

import gabi.clinic.demo.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
