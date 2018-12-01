package gabi.clinic.demo.repositories;

import gabi.clinic.demo.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
