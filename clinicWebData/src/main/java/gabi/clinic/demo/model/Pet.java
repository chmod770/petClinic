package gabi.clinic.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

<<<<<<< HEAD
public class Pet extends BaseEntity{
=======
@Getter @Setter
public class Pet {
>>>>>>> 9b1b93fed418821b3ffc4ef5832bde9a5bc3390d

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
}
