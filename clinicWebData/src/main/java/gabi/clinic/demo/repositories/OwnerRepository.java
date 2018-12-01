package gabi.clinic.demo.repositories;

import gabi.clinic.demo.model.Owner;
import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Owner, Long> {
     Owner findByLastName(String lastName);
}
